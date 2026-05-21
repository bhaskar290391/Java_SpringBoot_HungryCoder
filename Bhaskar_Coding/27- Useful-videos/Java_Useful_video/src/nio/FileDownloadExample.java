package nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class FileDownloadExample {

    private static final String FILE_URL="file:///C:/Users/A_R_COMPUTERS/Downloads/June_Payslip_2025.pdf";
    private static final String FILE_NAME="BHASKAR.pdf";

    public static void main() throws MalformedURLException {

        URL url=new URL(FILE_URL);

        try{
            ReadableByteChannel readableByteChannel= Channels.newChannel(url.openStream());
            FileOutputStream fileOutputStream=new FileOutputStream(FILE_NAME);

            FileChannel file=fileOutputStream.getChannel();
            file.transferFrom(readableByteChannel,0,Long.MAX_VALUE);

            file.close();
            fileOutputStream.close();
            readableByteChannel.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("File download successfully");

    }
}
