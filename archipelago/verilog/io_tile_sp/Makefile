all: compile

basedir = ../..

DIR_NAME = io_tile_sp
PROJ_NAME = io_tile_sp

src_files := Makefile $(basedir)/src/$(DIR_NAME)/*.scala
verilog_timestamp := $(basedir)/verilog/$(DIR_NAME)/generated-src/timestamp

SBT:= java -Xmx8G -Xss1G -XX:MaxPermSize=8G -jar sbt-launch.jar
options = fpga_components.io_tile_sp_gen_main --backend v --targetDir ../verilog/${DIR_NAME}/generated-src

target:
	@echo "  "
	@echo "   The current make target is: ${PROJ_NAME}"
	@echo "  "

compile:
	cd $(basedir)/sbt; ${SBT} "project ${PROJ_NAME}" "run $(options)"

$(verilog_timestamp): $(src_files)
	cd $(basedir)/sbt; ${SBT} "project ${PROJ_NAME}" "run $(options)"
	date > $(verilog_timestamp);

clean:
	rm -rf generated-src

.PHONY: all clean
