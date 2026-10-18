LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/ash-134/aeld-assignment-6-.git;protocol=https;branch=a6-source"
PV = "1.0+git${SRCPV}"
SRCREV = "be0181e9fb8e0275e1bab691ba685b3e268b8b2c"

S = "${WORKDIR}/git/server"

FILES:${PN} += "${bindir}/aesdsocket"
FILES:${PN} += "${sysconfdir}/init.d/S99aesdsocket"

TARGET_LDFLAGS += "-pthread -lrt"

inherit update-rc.d
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "S99aesdsocket"

do_configure () {
	:
}

do_compile () {
	oe_runmake
}

do_install () {
	install -d 0755 ${D}${bindir}
	install -m 0755 ${S}/aesdsocket ${D}${bindir}/

	install -d 0755 ${D}${sysconfdir}/init.d
	install -m 0755 ${S}/aesdsocket-start-stop ${D}${sysconfdir}/init.d/S99aesdsocket
}
