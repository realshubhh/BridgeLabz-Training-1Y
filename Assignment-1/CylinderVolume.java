import java.util.Scanner;
	public class CylinderVolume {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter radius: ");
			double radius = sc.nextDouble();
			System.out.print("Enter height: ");
			double height = sc.nextDouble();
			double volume = Math.PI * Math.pow(radius, 2) * height;
			System.out.println("Volume: " + volume);
    }
}