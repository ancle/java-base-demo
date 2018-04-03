package state.room.state.impl;

import state.room.context.Room;
import state.room.state.RoomState;

public class BookedState implements RoomState {
	
	private Room room;
	
	public BookedState(Room room) {
		this.room = room;
	}

	@Override
	public void bookRoom() {
		System.out.println("房间（" + this.room.getRoomNo() + "）已被预订了");
	}

	@Override
	public void checkInRoom() {
		System.out.println("您已成功入住房间(" + this.room.getRoomNo() + ")");
		this.room.setRoomState(this.room.getCheckInState());
	}

	@Override
	public void unsubscribeRoom() {
		this.room.setRoomState(this.room.getFreeState());
		System.out.println("房间（" + this.room.getRoomNo() + ")退订成功，欢迎下次光临");
	}

	@Override
	public void checkOutRoom() {
		// do nothing
	}

}
