class SumRange {
    public static void main(String [] args) {

      if(args.length < 2) {
          System.out.println("Specify two positive integers");
          System.exit(0);
      }
      
      int x = Integer.parseInt(args[0]);
      int y = Integer.parseInt(args[1]);


      int sum = 0;

      for (int i = x; i<y+1 ;i++ ) {
        sum = sum + i;
      }

        System.out.println("Sum of [" + args[0] + "," + args[1] + "] is "+ sum);
    }
}
