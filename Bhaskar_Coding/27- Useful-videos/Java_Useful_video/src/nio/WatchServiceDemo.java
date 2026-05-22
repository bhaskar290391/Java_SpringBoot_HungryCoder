package nio;

import java.io.IOException;
import java.nio.file.*;

public class WatchServiceDemo {
    static void main() throws IOException, InterruptedException {





                // Create a WatchService
                WatchService watchService = FileSystems.getDefault().newWatchService();

                // Get the directory to watch
                Path directory = Paths.get("D:\\Bhaskar_Learning_and_Development\\Java_SpringBoot_HungryCoder\\Bhaskar_Coding\\27- Useful-videos\\Java_Useful_video\\src"); // Directory to watch

                // Register the directory with the WatchService
                directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
                        StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

                // Enter the main event loop
                while (true) {
                    // Wait for events
                    WatchKey key = watchService.take();

                    // Iterate over the events
                    for (WatchEvent<?> event : key.pollEvents()) {

                        WatchEvent<Path> ev = (WatchEvent<Path>) event;
                        Path filename = ev.context();

                        // Handle each event
                        if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                            System.out.println("File created");
                            // Print the event type and filename
                            System.out.println(event.kind() + ": " + filename);
                        }


                        if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                            System.out.println("File Deleted");
                            // Print the event type and filename
                            System.out.println(event.kind() + ": " + filename);
                        }

                        if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                            System.out.println("File Modify");
                            // Print the event type and filename
                            System.out.println(event.kind() + ": " + filename);
                        }




                    }

                    // Reset the key
                    boolean valid = key.reset();
                    if (!valid) {
                        // Key is no longer valid, exit the loop
                        break;
                    }
                }
            }
        }
