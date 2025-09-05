# -------------------------------------------------------------------
# Project settings
# -------------------------------------------------------------------
PROJ_ROOT  ?= .
MVN_TARGET ?= $(PROJ_ROOT)/target
SOURCES    ?= $(PROJ_ROOT)/src
C_SRC      ?= $(SOURCES)/main/c
C_GEN_SRC  ?= $(SOURCES)/generated/c
JAVA_SRC   ?= $(SOURCES)/main/java

# Detectar JAVA_HOME automáticamente
JAVA_BIN := $(shell readlink -f $(shell which java))
JAVA_HOME := $(shell dirname $(shell dirname $(JAVA_BIN)))

# -------------------------------------------------------------------
# Compiler settings
# -------------------------------------------------------------------
JAVAC  ?= javac
CC     ?= gcc
CFLAGS += -fPIC -O3 -I"$(JAVA_HOME)/include" -I"$(JAVA_HOME)/include/linux"

# -------------------------------------------------------------------
# Targets
# -------------------------------------------------------------------
all:	liblwtkmath.so

generate-c:
	@mkdir -p $(C_GEN_SRC)
	$(JAVAC) $(JAVA_SRC)/org/lwtk/math/exp/Vec4.java \
		--source-path $(JAVA_SRC) -h $(C_GEN_SRC) -d $(MVN_TARGET)

liblwtkmath.so: generate-c
	$(CC) $(CFLAGS) -I"$(C_GEN_SRC)" -shared -o $@ $(C_SRC)/*.c

clean:
	rm -f liblwtkmath.so
	rm -rf $(C_GEN_SRC)
	rm -rf $(MVN_TARGET)
