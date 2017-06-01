DESCRIPTION = "Winpthreads runtime libraries from MinGW-w64 project"
LICENSE = "ZPL-2.1"
LIC_FILES_CHKSUM = "file://../../COPYING;md5=bb936f0e04d8f1e19ad545100cee9654"

COMPATIBLE_HOST = ".*-mingw.*"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/mingw-w64/mingw-w64/mingw-w64-release/mingw-w64-v${PV}.tar.bz2"
SRC_URI[md5sum] = "c9f4bb72a87d9be2cc98e0d7e1868c88"
SRC_URI[sha256sum] = "e41d8ca739e22b4215c8ebe99ed2fc398c734cae73877f3143c394661b096d08"

S = "${WORKDIR}/mingw-w64-v${PV}/mingw-w64-libraries/winpthreads"
B = "${WORKDIR}/build-${TARGET_SYS}"

inherit autotools nativesdk

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS = "nativesdk-mingw-w64-runtime"

do_configure() {
    oe_runconf
}

STAGINGCC = "gcc-cross-initial-${TARGET_ARCH}"
STAGINGCC_class-nativesdk = "gcc-crosssdk-initial-${SDK_SYS}"
TOOLCHAIN_OPTIONS = " --sysroot=${STAGING_DIR_TARGET}"
PATH_prepend = "${STAGING_BINDIR_TOOLCHAIN}.${STAGINGCC}:"

do_install_append() {
    # headers are already installed by mingw-w64-headers
    rm -rf ${D}${includedir}
}
