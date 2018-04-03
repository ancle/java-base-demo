package state.room.state.impl;

import state.room.context.Room;
import state.room.state.RoomState;

public class FreeTimeState implements RoomState {
	
	private Room room;
	
	public FreeTimeState(Room room) {
		this.room = room;
	}

	@Override
	public void bookRoom() {
		System.out.println("您已成功预订了房间（" + this.room.getRoomNo() + "）");
		this.room.setRoomState(this.room.getBookedState());;
	}

	@Override
	public void checkInRoom() {
		System.out.println("您已成功入住房间（" + this.room.getRoomNo() + "）");
		this.room.setRoomState(this.room.getCheckInState());
	}

	@Override
	public void unsubscribeRoom() {
		// do nothing
	}

	@Override
	public void checkOutRoom() {
		// do nothing
	}

}
