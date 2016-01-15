DESCRIPTION = "Header files from the MingGW-w64 project"
LICENSE = "ZPL-2.1"
LIC_FILES_CHKSUM = "file://../COPYING;md5=bb936f0e04d8f1e19ad545100cee9654"

COMPATIBLE_HOST = ".*-mingw.*"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/mingw-w64/mingw-w64/mingw-w64-release/mingw-w64-v${PV}.tar.bz2 \
           file://epsilon.patch"

SRC_URI[md5sum] = "3c56901ca7be60beba6d58caff168240"
SRC_URI[sha256sum] = "44764daa65f9adf562b0456e7b681c73c074dc6d1d3ae210f6000af0b641fcef"

S = "${WORKDIR}/mingw-w64-v${PV}/mingw-w64-headers"
B = "${WORKDIR}/build-${TARGET_SYS}"

inherit autotools nativesdk

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = ""

do_configure() {
	oe_runconf
}

do_compile() {
	:
}

FILES_${PN} += "${exec_prefix}/${TARGET_SYS}"
