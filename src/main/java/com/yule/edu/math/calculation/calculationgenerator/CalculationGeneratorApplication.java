package com.yule.edu.math.calculation.calculationgenerator;

import com.yule.edu.math.calculation.calculationgenerator.service.AdditionStrategy;
import com.yule.edu.math.calculation.calculationgenerator.service.CalculationGenerator;
import com.yule.edu.math.calculation.calculationgenerator.service.IOperationStrategy;
import com.yule.edu.math.calculation.calculationgenerator.service.Parameters;
import com.yule.edu.math.calculation.calculationgenerator.service.SubtractionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;

@SpringBootApplication
public class CalculationGeneratorApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculationGeneratorApplication.class);


    private CalculationGenerator calculationGenerator;

    @Autowired
    public CalculationGeneratorApplication(CalculationGenerator calculationGenerator) {
        this.calculationGenerator=calculationGenerator;
    }

    public static void main(String[] args) {
        SpringApplication.run(CalculationGeneratorApplication.class, args);
    }


    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            IOperationStrategy[] ops = new IOperationStrategy[]{
                    new AdditionStrategy(new Parameters.Add(20)),
                    new SubtractionStrategy(20)
            };

            Collection<String> questions = calculationGenerator.generate(2000, ops);

            writeFile(questions);
        };
    }

    private void writeFile(Collection<String> questions) {
        RandomAccessFile stream = null;
        FileChannel channel = null;
        try {
            stream = new RandomAccessFile(String.format("question-%s.txt", System.currentTimeMillis()), "rw");

            channel = stream.getChannel();
            FileChannel finalChannel = channel;
            questions.forEach(question -> {
                byte[] strBytes = question.getBytes();
                ByteBuffer buffer = ByteBuffer.allocate(strBytes.length);
                buffer.put(strBytes);
                buffer.flip();
                try {
                    finalChannel.write(buffer);
                } catch (IOException e) {
                    LOGGER.error("error", e);
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stream!=null){
                    stream.close();
                }
               if(channel!=null) {
                   channel.close();
               }
            } catch (IOException e) {
                LOGGER.error("error", e);
            }
        }


    }

}
