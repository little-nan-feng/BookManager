package dao;

import org.apache.ibatis.annotations.Insert;
import pojo.Record;

public interface RecordMapper {
    @Insert("insert into tb_record(name,isbn,borrower,borrowerTime,deadline,returnTime,status)"
    +"values(#{name},#{isbn},#{borrower},#{borrowTime},#{deadline},#{returnTime},#{status})")
    public int addRecord(Record record);

}
