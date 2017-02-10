DESCRIPTION = "Header files from the MingGW-w64 project"
LICENSE = "ZPL-2.1"
LIC_FILES_CHKSUM = "file://../COPYING;md5=bb936f0e04d8f1e19ad545100cee9654"

COMPATIBLE_HOST = ".*-mingw.*"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/mingw-w64/mingw-w64/mingw-w64-release/mingw-w64-v${PV}.tar.bz2 \
           file://epsilon.patch"

SRC_URI[md5sum] = "80d6884c9da234e73054347f44158b8a"
SRC_URI[sha256sum] = "5f46e80ff1a9102a37a3453743dae9df98262cba7c45306549ef7432cfd92cfd"

S = "${WORKDIR}/mingw-w64-v${PV}/mingw-w64-headers"
B = "${WORKDIR}/build-${TARGET_SYS}"

inherit autotools nativesdk

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = ""

PACKAGECONFIG ??= "secure-api"

PACKAGECONFIG[secure-api] = "--enable-secure-api,--disable-secure-api"

do_configure() {
	oe_runconf
}

do_compile() {
	:
}

FILES_${PN} += "${exec_prefix}/${TARGET_SYS}"
