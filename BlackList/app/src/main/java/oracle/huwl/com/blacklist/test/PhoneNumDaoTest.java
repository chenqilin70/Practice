package oracle.huwl.com.blacklist.test;

import android.test.AndroidTestCase;

import oracle.huwl.com.blacklist.PhoneNum;
import oracle.huwl.com.blacklist.PhoneNumDao;

/**
 * Created by aierxuan on 2017/7/9.
 */

public class PhoneNumDaoTest extends AndroidTestCase{
    public void testAdd(){
        PhoneNumDao dao=new PhoneNumDao(getContext());
        dao.add(new PhoneNum(null,"123456789"));
    }
}
