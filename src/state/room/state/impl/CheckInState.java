package state.room.state.impl;

import state.room.context.Room;
import state.room.state.RoomState;

public class CheckInState implements RoomState {
	private Room room;
	
	public CheckInState(Room room) {
		this.room = room;
	}

	@Override
	public void bookRoom() {
		System.out.println("房间（" + this.room.getRoomNo() + "）已经预订");
	}

	@Override
	public void checkInRoom() {
		System.out.println("您已入住房间（" + this.room.getRoomNo() + ")");
	}

	@Override
	public void unsubscribeRoom() {
		System.out.println("您已入住房间，不能取消预订。");
	}

	@Override
	public void checkOutRoom() {
		this.room.setRoomState(this.room.getFreeState());
		System.out.println("退房成功，欢迎下次光临");
	}

}
