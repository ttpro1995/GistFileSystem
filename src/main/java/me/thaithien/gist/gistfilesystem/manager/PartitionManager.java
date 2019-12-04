package me.thaithien.gist.gistfilesystem.manager;

import me.thaithien.gist.gistfilesystem.object.Partition;
import me.thaithien.gist.gistfilesystem.object.PartitionInfo;

import java.util.ArrayList;
import java.util.List;

public class PartitionManager {


    /**
     * Split string into part
     * @param encoded base64 of full file
     * @return array of partition info
     */
    public static PartitionInfo partitionEncodeString(String name, String encoded, int size){
        String[] result = null;
        result = encoded.split("(?<=\\G.{" + Integer.toString(size) +"})");
        List<Partition> result_list = new ArrayList<Partition>();
        for (int i = 0; i < result.length; i ++){
            result_list.add(new Partition(i, result[i]));
        }
        PartitionInfo info = new PartitionInfo(name, result_list, PartitionInfo.STATUS_ENCODED);
        return info;
    }

    /**
     * convert content of each partitionInfo into url
     * @param partitionInfo
     * @return
     */
    public static PartitionInfo uploadPartitionInfo(PartitionInfo partitionInfo){
         //    PartitionInfo uploadPartitionInfo = partitionInfo.

        // TODO: work on here
        return null;

    }
}
