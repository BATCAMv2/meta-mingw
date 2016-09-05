LDFLAGS_append_sdkmingw32 = " -Wl,-static"
EXEEXT_sdkmingw32 = ".exe"
PACKAGECONFIG_sdkmingw32 = ""
DEPENDS_remove_sdkmingw32 = "nativesdk-ncurses"
EXTRA_OECONF_append_sdkmingw32 = " --without-curses"

DISABLE_STATIC = ""
