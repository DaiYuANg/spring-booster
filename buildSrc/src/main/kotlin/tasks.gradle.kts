tasks.register("tree") {
  exec {
    commandLine("tree", "-L", "3", "-I", "*git|*build*|*bin*")
    //        standardOutput = new ByteArrayOutputStream()
  }
}
