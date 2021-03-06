package com.Travel.butler;

import java.net.InetSocketAddress;

import com.Travel.butler.utils.SpringUtil;
import com.Travel.netty.service.NewChatServer;
import com.Travel.netty.service.core.ServerThread;
import com.Travel.netty.tools.IniConf;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(value = {SpringUtil.class})
public class NettyWebSocketServerApplication implements CommandLineRunner{
    @Autowired
    private NewChatServer chatServer;

    @Bean
    public NewChatServer chatServer() {
        return new NewChatServer();
    }

    public static void main(String[] args) {
        SpringApplication.run(NettyWebSocketServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        new IniConf().iniConf();
        new Thread(new ServerThread()).start();
//        new ChatServer().run();


        InetSocketAddress address = new InetSocketAddress("0.0.0.0", 8855);
        ChannelFuture future = chatServer.start(address);

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                chatServer.destroy();
            }
        });

        future.channel().closeFuture().syncUninterruptibly();
    }
}
