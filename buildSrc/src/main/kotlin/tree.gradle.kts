tasks.register("tree") {
  exec {
    commandLine("tree", "-L", "20", "-I", "*git|*build*|*bin*")
  }
}
