package state.room.context;

import state.room.state.RoomState;
import state.room.state.impl.BookedState;
import state.room.state.impl.CheckInState;
import state.room.state.impl.FreeTimeState;

public class Room {
	private FreeTimeState freeState;
	private CheckInState checInState;
	private BookedState bookedState;
	
	private String roomNo;
	private RoomState roomState;
	
	public Room(String roomNo) {
		this.roomNo = roomNo;
		
		initState();
	}
	
	private void initState() {
		this.freeState = new FreeTimeState(this);
		this.checInState = new CheckInState(this);
		this.bookedState = new BookedState(this);
		
		this.roomState = this.freeState;
	}
	
	public void setRoomState(RoomState state) {
		this.roomState = state;
	}
	
	public void bookRoom() {
		roomState.bookRoom();
	}
	
	public void unsubscribeRoom() {
		roomState.unsubscribeRoom();
	}
	
	public void checkInRoom() {
		roomState.checkInRoom();
	}
	
	public void checkOutRoom() {
		roomState.checkOutRoom();
	}
	
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	
	public String getRoomNo() {
		return this.roomNo;
	}
	
	public RoomState getFreeState() {
		return this.freeState;
	}
	
	public RoomState getCheckInState() {
		return this.checInState;
	}
	
	public RoomState getBookedState() {
		return this.bookedState;
	}
	
	public String toString() {
		return "当前房间（" + this.roomNo + "）的状态为" + this.roomState.getClass().getName();
	}
}
