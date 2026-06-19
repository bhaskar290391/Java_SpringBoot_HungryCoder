package com.design.pattern.structural;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
	void showDetails();
}

class Files implements FileSystemComponent {

	String name;

	public Files(String name) {
		super();
		this.name = name;
	}

	@Override
	public void showDetails() {
		System.out.println("name of file is " + name);

	}

}

class Directory implements FileSystemComponent {
	String name;
	List<FileSystemComponent> components=new ArrayList<>();

	public Directory(String name) {
		this.name = name;
	}

	
	public void addComponent(FileSystemComponent componet) {
		components.add(componet);
	}
	
	public void removeComponent(FileSystemComponent componet) {
		components.remove(componet);
	}
	@Override
	public void showDetails() {
		System.out.println("Directory Name "+ name);
		for (FileSystemComponent fileSystemComponent : components) {
			fileSystemComponent.showDetails();
		}

	}

}

public class CompositeDesignDemo {
	public static void main(String[] args) {

		FileSystemComponent file1=new Files("File1.txt");
		FileSystemComponent file2=new Files("File2.txt");
		
		Directory dir1=new Directory("dir1");
		Directory dir2=new Directory("dir2");
		
        dir1.addComponent(file1);
        dir2.addComponent(file2);
        dir1.addComponent(dir2);

        dir1.showDetails();
	}
}
