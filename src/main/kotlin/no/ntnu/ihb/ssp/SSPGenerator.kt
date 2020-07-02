package no.ntnu.ihb.ssp

import picocli.CommandLine

@CommandLine.Command
class SSPGenerator {

   companion object {

       @JvmStatic
       fun main(args: Array<String>) {
            CommandLine(SSPGenerator()).execute(*args)
       }

   }

}
