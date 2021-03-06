######################################################################
#
# Toro common library
#
# Note: This make file is dependent on the platform-specific ISM 
#       environment variable.  ISM is platform-specific and is used 
#       to determine various build switches and directories.
#
#       This make file currently supports:
#       - setenv ISM linux_x86_64
#       - setenv ISM linux_i686
#       - setenv ISM sun8
#
######################################################################

######################################################################
# Compiler options
######################################################################

pC++linux_x86_64 = /usr/bin/gcc
pC++linux_i686 = /usr/bin/gcc
pC++sun8 = /apps/SUNWspro_6.0-U2/bin/CC
pC++ = $(pC++$(ISM))

PIClinux_x86_64 = -shared
PIClinux_i686 = -shared
PICsun8 = -G -KPIC
PIC = $(PIC$(ISM))

CFLAGSlinux_x86_64 = -Wall -Wpointer-arith -Wcast-qual -static -fPIC -DLINUX_X86_64
CFLAGSlinux_i686 = -Wall -Wpointer-arith -Wcast-qual -static -fPIC -DLINUX_I686
CFLAGSsun8 = +w -xarch=v9 -library=iostream,Cstd -DLP64 -DSUN8
CFLAGS = $(CFLAGS$(ISM)) \
	-I. \
	-I../TIO_InputOutputHandlers \
	-I../../libpcre/SRC

######################################################################
# Linker options
######################################################################

LINKERlinux_x86_64 = /usr/bin/ld
LINKERlinux_i686 = /usr/bin/ld
LINKERsun8 = /usr/ccs/bin/ld
LINKER = $(LINKER$(ISM))

LFLAGSlinux_x86_64 = -shared
LFLAGSlinux_i686 = -shared
LFLAGSsun8 = -G -library=iostream -xarch=v9
LFLAGS = $(LFLAGS$(ISM))

######################################################################
# Program files
######################################################################

PROG = libTC_Common
EXE = ../$(ISM)/$(PROG).a

ARCMDlinux_x86_64 = $(LINKER) -r -o $(ISM)/$(PROG).a $(OBJECTS) ; \
	mv $(ISM)/$(PROG).a $(EXE)
ARCMDlinux_i686 = $(LINKER) -r -o $(ISM)/$(PROG).a $(OBJECTS) ; \
	mv $(ISM)/$(PROG).a $(EXE)
ARCMDsun8 = $(pC++) -xar -xarch=v9 -library=iostream -o $(ISM)/$(PROG).a $(OBJECTS) ; \
	mv $(ISM)/$(PROG).a $(EXE)
ARCMD = $(ARCMD$(ISM))

SOLlinux_x86_64 = so
SOLlinux_i686 = so
SOLsun8 = so
SOL = $(SOL$(ISM))

LIBSOlinux_x86_64 = ../linux_x86_64/$(PROG).$(SOL)
LIBSOlinux_i686 = ../linux_i686/$(PROG).$(SOL)
LIBSOsun8 = ../sun8/$(PROG).$(SOL)
LIBSO = $(LIBSO$(ISM))

OBJSlinux_x86_64 = linux_x86_64/TC_Name.o \
                    linux_x86_64/TC_NameFile.o \
                    linux_x86_64/TC_NameType.o \
                    linux_x86_64/TC_NameIndex.o \
                    linux_x86_64/TC_NameLength.o \
                    linux_x86_64/TC_SideName.o \
                    linux_x86_64/TC_SideIndex.o \
                    linux_x86_64/TC_MapTable.o \
                    linux_x86_64/TC_Bit.o \
                    linux_x86_64/TC_MinGrid.o \
                    linux_x86_64/TC_RegExp.o \
                    linux_x86_64/TC_StringUtils.o \
                    linux_x86_64/TC_MemoryUtils.o 
OBJSlinux_i686 = linux_i686/TC_Name.o \
                    linux_i686/TC_NameFile.o \
                    linux_i686/TC_NameType.o \
                    linux_i686/TC_NameIndex.o \
                    linux_i686/TC_NameLength.o \
                    linux_i686/TC_SideName.o \
                    linux_i686/TC_SideIndex.o \
                    linux_i686/TC_MapTable.o \
                    linux_i686/TC_Bit.o \
                    linux_i686/TC_MinGrid.o \
                    linux_i686/TC_RegExp.o \
                    linux_i686/TC_StringUtils.o \
                    linux_i686/TC_MemoryUtils.o 
OBJSsun8 = sun8/TC_Name.o \
           sun8/TC_NameFile.o \
           sun8/TC_NameType.o \
           sun8/TC_NameIndex.o \
           sun8/TC_NameLength.o \
           sun8/TC_SideName.o \
           sun8/TC_SideIndex.o \
           sun8/TC_MapTable.o \
           sun8/TC_Bit.o \
           sun8/TC_MinGrid.o \
           sun8/TC_RegExp.o \
           sun8/TC_StringUtils.o \
           sun8/TC_MemoryUtils.o 
OBJECTS = $(OBJS$(ISM))

######################################################################
# Target rules
######################################################################

BUILD_TARGET =

all:
	make Debug
Optimized:
	make $(EXE) CFLAGS="-O2 $(CFLAGS)" BUILD_TARGET=Optimized
Debug:
	make $(EXE) CFLAGS="-g -DDEBUG $(CFLAGS)" BUILD_TARGET=Debug
Gprof:
	make $(EXE) CFLAGS="-pg -g -DDEBUG $(CFLAGS)" BUILD_TARGET=Debug
clean:
	rm -rf $(ISM)/*

.cxx.o:;
.cxx.a:;

######################################################################
# Program rules
######################################################################

$(EXE): $(LIBSO)
	$(ARCMD)

$(LIBSOlinux_x86_64): $(OBJECTS) Makefile
	$(pC++) $(LFLAGS) -o $(ISM)/$(PROG).$(SOL) $(OBJECTS) ; \
	mv $(ISM)/$(PROG).$(SOL) $@
$(LIBSOlinux_i686): $(OBJECTS) Makefile
	$(pC++) $(LFLAGS) -o $(ISM)/$(PROG).$(SOL) $(OBJECTS) ; \
	mv $(ISM)/$(PROG).$(SOL) $@
$(LIBSOsun8): $(OBJECTS) Makefile
	$(pC++) $(LFLAGS) -o $(ISM)/$(PROG).$(SOL) $(OBJECTS) ; \
	mv $(ISM)/$(PROG).$(SOL) $@

$(OBJECTS): $(ISM)/%.o:%.cxx
	$(pC++) -o $@ -c $(@F:.o=.cxx) $(PIC) $(CFLAGS)

######################################################################
# Library rules
######################################################################

../$(ISM)/libTIO_InputOutputHandlers.a:
	cd ../TIO_InputOutputHandlers ; $(MAKE) $(BUILD_TARGET)
