FILES_${PN}_append_mingw32 = " ${bindir}/libgcc*.dll"
FILES_${PN}-dev_append_mingw32 = " ${base_libdir}/libgcc*.a"

do_install_append_mingw32() {
    install -d -m 0755 ${D}${bindir}
    mv ${D}${base_libdir}/libgcc*.dll ${D}${bindir}/
}
