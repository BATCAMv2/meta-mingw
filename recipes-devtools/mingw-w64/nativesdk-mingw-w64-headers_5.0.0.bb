DESCRIPTION = "Header files from the MingGW-w64 project"
LICENSE = "ZPL-2.1"
LIC_FILES_CHKSUM = "file://../COPYING;md5=bb936f0e04d8f1e19ad545100cee9654"

COMPATIBLE_HOST = ".*-mingw.*"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/mingw-w64/mingw-w64/mingw-w64-release/mingw-w64-v${PV}.tar.bz2 \
           file://epsilon.patch"

SRC_URI[md5sum] = "c9f4bb72a87d9be2cc98e0d7e1868c88"
SRC_URI[sha256sum] = "e41d8ca739e22b4215c8ebe99ed2fc398c734cae73877f3143c394661b096d08"

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

do_install_append() {
    # install correct pthread headers
    install -m 0644 -t ${D}${includedir} ${S}/../mingw-w64-libraries/winpthreads/include/*.h
}

FILES_${PN} += "${exec_prefix}/${TARGET_SYS}"
