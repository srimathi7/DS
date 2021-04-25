//Using Streams
class BinaryWatch {
   public List<String> readBinaryWatch(int turnedOn) {
    return IntStream.range(0,12)
        .boxed()
        .flatMap(h -> IntStream.range(0,60)
                 .filter(m -> Integer.bitCount(h) + Integer.bitCount(m) == turnedOn)
                  .mapToObj(mm -> h + ":" + (mm < 10 ? "0" : "") + mm))
                  .collect(Collectors.toList());                 
}
}
