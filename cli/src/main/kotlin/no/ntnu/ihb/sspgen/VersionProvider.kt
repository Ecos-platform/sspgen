package no.ntnu.ihb.sspgen

import picocli.CommandLine

class VersionProvider : CommandLine.IVersionProvider {

    override fun getVersion(): Array<String> {
        return arrayOf(sspgen.version)
    }
}
