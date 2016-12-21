public class TempConv{

  public static double CtoF(double t){
    return (t * 9 / 5) + 32;
  }

  public static double FtoC(double t){
    return (t - 32) * 5 / 9;
  }
  
  // public static void main(String[] args){
  //   System.out.println(CtoF(-40.0)); // -40.0
  //   System.out.println(CtoF(100.0)); // 212.0
  //   System.out.println(FtoC(212.0)); // 100.0
  // }
}
