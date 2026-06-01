package com.NIO;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class WatchServiceExample {
	public static void main(String[] args) {

		try {
			WatchService newWatchService = FileSystems.getDefault().newWatchService();

			Path directory = Paths.get(
					"D:\\Bhaskar_Learning_and_Development\\Java_SpringBoot_HungryCoder\\Bhaskar_Coding\\10 -Hand-on-Coding\\Bhaskar_code\\src\\com\\NIO");

			directory.register(newWatchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
			
			while(true) {
				WatchKey key = newWatchService.take();
				
				for(WatchEvent<?> data:key.pollEvents()) {
					 System.out.println("Event kind:" + data.kind() + ". File affected: " + data.context() + ".");
				}
				key.reset();
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
