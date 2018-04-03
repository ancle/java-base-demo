package state.test;

import state.room.context.Room;

public class RoomTest {

	public static void main(String[] args) {
		Room R4005 = new Room("R4005");
		
		R4005.checkOutRoom();
		R4005.bookRoom();
		R4005.checkInRoom();
		R4005.unsubscribeRoom();
		R4005.checkOutRoom();
	}

}
