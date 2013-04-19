package ceedubs.config
package readers

import com.typesafe.config.ConfigFactory

class ConfigReaderSpec extends Spec with ConfigReader with AnyValReaders { def is =
  "The Config value reader should" ^
    "read a config" ! readConfig

  def readConfig = {
    val cfg = ConfigFactory.parseString(
      """
        |myConfig {
        |  myValue = true
        |}
      """.stripMargin)
    ConfigValueReader.get(cfg, "myConfig").getBoolean("myValue") must beTrue
  }
}
