//generic method to find highest in an generic array

class Main {
  public static void main(String[] args) {
    Integer arr[]={5,6,1,8};

    System.out.println(max(arr));
  }
  public static <T extends Comparable<T>> T max(T elements[]) {
    T max = elements[0];
    for (T element : elements) {
        if (element.compareTo(max) > 0) {
            max = element;
        }
    }
    return max;
  }
}