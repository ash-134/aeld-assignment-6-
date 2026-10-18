#!/bin/bash
source $(dirname $0)/poky/oe-init-build-env $(dirname $0)/build 2>/dev/null || source $(dirname $0)/bitbake-builds/poky-master/build/init-build-env 2>/dev/null || true
runqemu nographic slirp qemuparams="-netdev user,id=net0,hostfwd=tcp::9000-:9000,hostfwd=tcp::10022-:22"
