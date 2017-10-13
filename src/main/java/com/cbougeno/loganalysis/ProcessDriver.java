package com.cbougeno.loganalysis;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ProcessDriver extends Configured {

    public static void main(String[] args) throws IOException, InterruptedException,
            ClassNotFoundException {

        if (args.length != 2) {
            System.out.println("Usage: WordCount <input dir> <output dir> \n");
            System.exit(-1);
        }

        Job job = new Job(new Configuration());

        job.setJarByClass(ProcessDriver.class);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

//        job.setMapperClass(LogFileMapper.class);
//        job.setReducerClass(SumReducer.class);
//        job.setMapOutputKeyClass(Text.class);
//        job.setMapOutputValueClass(IntWritable.class);
//        job.setOutputKeyClass(Text.class);
//        job.setOutputValueClass(IntWritable.class);
        
        boolean success = job.waitForCompletion(true);
        System.exit(success ? 0 : 1);

    }

}
