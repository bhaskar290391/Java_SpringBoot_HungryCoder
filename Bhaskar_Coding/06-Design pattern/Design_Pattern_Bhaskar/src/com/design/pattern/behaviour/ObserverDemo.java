package com.design.pattern.behaviour;

import java.util.ArrayList;
import java.util.List;

interface Subject {

	public void attach(Observer observer);

	public void detach(Observer observer);

	public void notifyObserver();
}

class ConcreteSubject implements Subject {

	private List<Observer> observerList = new ArrayList<>();
	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		notifyObserver();
	}

	@Override
	public void attach(Observer observer) {
		observerList.add(observer);

	}

	@Override
	public void detach(Observer observer) {
		observerList.remove(observer);

	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observerList) {
			observer.update();
		}

	}

}

interface Observer {

	void update();
}

class ConcreteObserver implements Observer {

	private ConcreteSubject subject;
	private String name;

	public ConcreteObserver(ConcreteSubject subject, String name) {
		super();
		this.subject = subject;
		this.name = name;
		subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Observer " + name + " is notified .New State is " + subject.getState());
	}

}

public class ObserverDemo {
	public static void main(String[] args) {

		ConcreteSubject subject = new ConcreteSubject();
		
		ConcreteObserver observer1=new ConcreteObserver(subject, "observer 1");
		ConcreteObserver observer2=new ConcreteObserver(subject, "observer 2");
		
		subject.setState("state 1");
		subject.setState("state 2");
		
		subject.detach(observer2);
		subject.setState("state 3");
	}

}
