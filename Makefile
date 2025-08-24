BUILD_DIR     = out
MAIN_BUILD    = $(BUILD_DIR)/main
TEST_BUILD    = $(BUILD_DIR)/test
COVERAGE_DIR  = $(BUILD_DIR)/coverage

SRC_MAIN      = src/main
SRC_TEST      = src/test

LIB_DIR       = lib
TOOL_DIR      = tools

GJF_VERSION = 1.28.0
GJF_JAR     = $(TOOL_DIR)/google-java-format.jar
GJF_URL     = https://maven.org/maven2/com/google/googlejavaformat/google-java-format/$(GJF_VERSION)/google-java-format-$(GJF_VERSION)-all-deps.jar

JUNIT_VERSION = 1.13.4
JUNIT_JAR     = $(TOOL_DIR)/junit-platform-console-standalone.jar
JUNIT_URL     = https://maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$(JUNIT_VERSION)/junit-platform-console-standalone-$(JUNIT_VERSION).jar

JACOCO_VERSION = 0.8.13
JACOCO_BASE    = https://maven.org/maven2/org/jacoco

JACOCO_CLI_VERSION = $(JACOCO_VERSION)
JACOCO_CLI_JAR     = $(TOOL_DIR)/jacococli.jar
JACOCO_CLI_URL     = $(JACOCO_BASE)/org.jacoco.cli/$(JACOCO_CLI_VERSION)/org.jacoco.cli-$(JACOCO_CLI_VERSION)-nodeps.jar

JACOCO_AGENT_VERSION = $(JACOCO_VERSION)
JACOCO_AGENT_JAR     = $(TOOL_DIR)/jacocoagent-runtime.jar
JACOCO_AGENT_URL     = $(JACOCO_BASE)/org.jacoco.agent/$(JACOCO_AGENT_VERSION)/org.jacoco.agent-$(JACOCO_AGENT_VERSION)-runtime.jar

JAVA_SOURCES      = $(shell find $(SRC_MAIN) -name "*.java")
JAVA_TEST_SOURCES = $(shell find $(SRC_TEST) -name "*.java")

DISTRO_JAR = org.x96.sys.foundation.cs.ast.jar

build: clean/build/main
	@javac -d $(MAIN_BUILD) $(JAVA_SOURCES)
	@echo "[🚜] [compiled] [$(MAIN_BUILD)] successfully!"

build/test: kit clean/build/test build
	@javac -d $(TEST_BUILD) -cp "$(JUNIT_JAR):$(MAIN_BUILD)" $(JAVA_TEST_SOURCES)
	@echo "[🤖] [compiled] [$(TEST_BUILD)] successfully!"

test: build/test
	@java -jar $(JUNIT_JAR) \
     execute \
     --class-path $(TEST_BUILD):$(MAIN_BUILD) \
     --scan-class-path

test/coverage: build/test
	@mkdir -p $(COVERAGE_DIR)
	@echo "📊 Executando testes com cobertura..."
	@java -javaagent:$(JACOCO_AGENT_JAR)=destfile=$(COVERAGE_DIR)/jacoco.exec \
       -jar $(JUNIT_JAR) \
       execute \
       --class-path $(TEST_BUILD):$(MAIN_BUILD) \
       --scan-class-path


coverage/report: test/coverage
	@echo "📋 Gerando relatório de cobertura..."
	@java -jar $(JACOCO_CLI_JAR) report $(COVERAGE_DIR)/jacoco.exec \
	   --classfiles $(MAIN_BUILD) \
	   --sourcefiles src/main \
	   --html $(COVERAGE_DIR)/html \
	   --xml $(COVERAGE_DIR)/jacoco.xml \
	   --csv $(COVERAGE_DIR)/jacoco.csv
	@echo "✅ Relatório em $(COVERAGE_DIR)/html/index.html"

distro:
	@echo "📦 Criando JAR distribuível..."
	@jar cf $(DISTRO_JAR) -C $(MAIN_BUILD) .
	@echo "✅ JAR criado: $(DISTRO_JAR)"


define deps
$1/$2: $1
	@if [ ! -f "$$($3_JAR)" ]; then \
		echo "[📦] [🚛] [$$($3_VERSION)] [$2]"; \
		curl -sSL -o $$($3_JAR) $$($3_URL); \
	else \
		echo "[📦] [📍] [$$($3_VERSION)] [$2]"; \
	fi
endef

kit: \
	$(TOOL_DIR)/junit \
	$(TOOL_DIR)/gjf \
	$(TOOL_DIR)/jacoco_cli \
	$(TOOL_DIR)/jacoco_agent

$(eval $(call deps,$(TOOL_DIR),junit,JUNIT))
$(eval $(call deps,$(TOOL_DIR),gjf,GJF))
$(eval $(call deps,$(TOOL_DIR),jacoco_cli,JACOCO_CLI))
$(eval $(call deps,$(TOOL_DIR),jacoco_agent,JACOCO_AGENT))

$(BUILD_DIR) $(MAIN_BUILD) $(TEST_BUILD) $(COVERAGE_DIR) $(TOOL_DIR) $(LIB_DIR):
	@mkdir -p $@

clean/build:
	@rm -rf $(BUILD_DIR)
	@echo "[🧽] [clean] [$(BUILD_DIR)]"

clean/build/main:
	@rm -rf $(MAIN_BUILD)
	@echo "[🧼] [clean] [$(MAIN_BUILD)]"

clean/build/test:
	@rm -rf $(TEST_BUILD)
	@echo "[🧹] [clean] [$(TEST_BUILD)]"

clean/kit:
	@rm -rf $(TOOL_DIR)
	@echo "[🛀] [clean] [$(TOOL_DIR)]"

clean/libs:
	@rm -rf $(LIB_DIR)
	@echo "[🥽] [clean] [$(LIB_DIR)]"

clean: \
	clean/build \
	clean/build/main \
	clean/build/test \
	clean/kit \
	clean/libs
	@echo "[🔬] [clean]"
