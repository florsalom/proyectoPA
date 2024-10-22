package BLL;
public class Hotel_Singleton {
	private static Hotel hotel;
	private Hotel_Singleton(){
		hotel=null;
	}
	public static Hotel getHotel() {
		if (hotel==null) {
			hotel = new Hotel();
		} else {
			System.out.println("Ya existe");
		}
		
		
		return hotel;
	}
}
