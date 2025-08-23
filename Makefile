# Diretórios
BUILD_DIR     = build
MAIN_BUILD    = $(BUILD_DIR)/main
TEST_BUILD    = $(BUILD_DIR)/test
COVERAGE_DIR  = $(BUILD_DIR)/coverage

SRC_MAIN      = src/main
SRC_CLI       = src/cli
SRC_TEST      = src/test

LIB_DIR       = lib
TOOL_DIR      = tools

JUNIT_VERSION = 1.13.4
JUNIT_JAR     = $(TOOL_DIR)/junit-platform-console-standalone.jar
JUNIT_URL     = https://maven.org/maven2/org/junit/platform/junit-platform-console-standalone/$(JUNIT_VERSION)/junit-platform-console-standalone-$(JUNIT_VERSION).jar

GJF_VERSION   = 1.28.0
GJF_JAR       = $(TOOL_DIR)/google-java-format.jar
GJF_URL       = https://maven.org/maven2/com/google/googlejavaformat/google-java-format/$(GJF_VERSION)/google-java-format-$(GJF_VERSION)-all-deps.jar

JACOCO_VERSION   = 0.8.12
JACOCO_JAR       = $(TOOL_DIR)/jacoco-agent.jar
JACOCO_CLI       = $(TOOL_DIR)/jacoco-cli.jar
JACOCO_AGENT_URL = https://repo1.maven.org/maven2/org/jacoco/org.jacoco.agent/$(JACOCO_VERSION)/org.jacoco.agent-$(JACOCO_VERSION)-runtime.jar
JACOCO_CLI_URL   = https://repo1.maven.org/maven2/org/jacoco/org.jacoco.cli/$(JACOCO_VERSION)/org.jacoco.cli-$(JACOCO_VERSION)-nodeps.jar

JAVA_SOURCES      = $(shell find $(SRC_MAIN) -name "*.java")
JAVA_TEST_SOURCES = $(shell find $(SRC_TEST) -name "*.java")

DISTRO_JAR=org.x96.sys.foundation.cs.ast.jar

all: clean build build-test coverage


build:
	@mkdir -p $(MAIN_BUILD)
	@javac -d $(MAIN_BUILD) $(JAVA_SOURCES)

build-test: build tools/junit | $(TEST_BUILD)
	@javac -d $(TEST_BUILD) -cp $(MAIN_BUILD):$(JUNIT_JAR) $(JAVA_TEST_SOURCES)

test: build-test
	@java -jar $(JUNIT_JAR) execute \
	   --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CLI_BUILD) \
	   --scan-class-path

test-coverage: build-test tools/jacoco | $(COVERAGE_DIR)
	@echo "📊 Executando testes com cobertura..."
	@java -javaagent:$(JACOCO_JAR)=destfile=$(COVERAGE_DIR)/jacoco.exec,excludes=java.*:javax.*:sun.*:jdk.*:com.sun.*:org.junit.* \
	   -jar $(JUNIT_JAR) \
	   execute \
	   --class-path $(TEST_BUILD):$(MAIN_BUILD):$(CLI_BUILD) \
	   --scan-class-path

coverage: test-coverage
	@echo "📋 Gerando relatório de cobertura..."
	@java -jar $(JACOCO_CLI) report $(COVERAGE_DIR)/jacoco.exec \
	   --classfiles $(MAIN_BUILD) \
	   --sourcefiles src/main \
	   --html $(COVERAGE_DIR)/html \
	   --xml $(COVERAGE_DIR)/jacoco.xml \
	   --csv $(COVERAGE_DIR)/jacoco.csv
	@echo "✅ Relatório em $(COVERAGE_DIR)/html/index.html"

distro:
	jar cf $(DISTRO_JAR) -C $(MAIN_BUILD) .

# Downloads
tools:
	@mkdir -p $(TOOL_DIR)

tools/junit: tools
	@[ -f $(JUNIT_JAR) ] || (echo "📦 Baixando JUnit..."; curl -L -o $(JUNIT_JAR) $(JUNIT_URL))

tools/gjf: tools
	@[ -f $(GJF_JAR) ] || (echo "📦 Baixando Google Java Format..."; curl -L -o $(GJF_JAR) $(GJF_URL))

tools/jacoco: tools
	@[ -f $(JACOCO_JAR) ] || (echo "📦 Baixando JaCoCo Agent..."; curl -L -o $(JACOCO_JAR) $(JACOCO_AGENT_URL))
	@[ -f $(JACOCO_CLI) ] || (echo "📦 Baixando JaCoCo CLI..."; curl -L -o $(JACOCO_CLI) $(JACOCO_CLI_URL))

# Formatação
format: tools/gjf
	@find src -name "*.java" -print0 | xargs -0 java -jar $(GJF_JAR) --aosp --replace

# Limpeza
clean:
	@rm -rf $(BUILD_DIR)

$(TEST_BUILD) $(COVERAGE_DIR):
	@mkdir -p $@
