package io.github.tesla.gateway.netty.servlet;


import java.io.IOException;

import javax.servlet.ServletInputStream;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;


public class ChannelBufferServletInputStream extends ServletInputStream {

  private final ByteBuf byteBuf;

  public ChannelBufferServletInputStream(ByteBuf byteBuf) {
    this.byteBuf = byteBuf;
  }

  @Override
  public int read() throws IOException {
    ByteBufInputStream byteBufInputStream = new ByteBufInputStream(byteBuf);
    try {
      return byteBufInputStream.read();
    } finally {
      byteBufInputStream.close();
    }

  }

}
