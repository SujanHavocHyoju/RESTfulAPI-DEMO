package com.havoc.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.havoc.messenger.database.DatabaseClass;
import com.havoc.messenger.exception.DataNotFoundException;
import com.havoc.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L, new Message(1, "message 1", "Havoc"));
		messages.put(2L, new Message(2, "Message no 2", "Sujan"));
		messages.put(3L, new Message(3, "Message no 3", "Just Sul"));
		
	}
	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());
		
		/*Message m1 = new Message(1, "Message no 1", "Havoc");
		Message m2 = new Message(2, "Message no 2", "Sujan");
		List<Message> messageList = new ArrayList<>();
		messageList.add(m1);
		messageList.add(m2);
		return messageList;*/
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messageForYear=new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message:messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				messageForYear.add(message);
			}
		}
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start+size>list.size())
			return new ArrayList<Message>();
		return list.subList(start, start+size);
	}
	
	public Message getMessage(long id){
		Message message = messages.get(id);
		if(message == null){
			throw new DataNotFoundException("Message with id: "+id+" not found!");
		}
		return message;
		//return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	
	

}
