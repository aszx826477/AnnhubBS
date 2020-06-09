
ServerSocket serverSocket=new ServerSocket(8000);


serverSocket.setReuseAddress(true);      //设置ServerSocket的选项

    try {
            byte[] buff = new byte[4];
            DatagramSocket ds = new DatagramSocket(1935);
            DatagramPacket dp = new DatagramPacket(buff, buff.length);
            while (true) {
                ds.receive(dp);//此方法会一直阻塞，直到获取到数据
                System.out.println(new String(buff));
            }
            
        } catch (IOException e) {
            System.out.println("e "+e.getMessage());
            e.printStackTrace();

        } 

