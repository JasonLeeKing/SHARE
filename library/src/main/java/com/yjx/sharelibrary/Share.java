package com.yjx.sharelibrary;/**
 * Created by yjx on 15/5/22.
 */

import android.graphics.Bitmap;
import android.os.Handler;

import com.yjx.sharelibrary.cache.DiskCache;
import com.yjx.sharelibrary.cache.MemoryCache;

/**
 * User: YJX
 * Date: 2015-05-22
 * Time: 15:08
 * 主体类
 */
public final class Share {
    //任务处理
    private static Handler handler;
    //名字
    private static String shareName;
    //缓存大小
    private static int cacheSize;
    private static DiskCache diskCache = null;
    private static MemoryCache memoryCache = null;


    /**
     * 初始化
     */
    public static void init(String shareName, int cacheSize, String path, Handler handler) {
        Share.shareName = shareName;
        Share.cacheSize = cacheSize;
        Share.handler = handler;
        Share.memoryCache = new MemoryCache();
        Share.diskCache = new DiskCache(cacheSize, path, 1);

    }

    /**
     * 设置int类型的值
     * @param key 键
     * @param value 值
     */
    public static void putInt(String key, int value) {
        Share.memoryCache.put(key, new Integer(value));
        Share.diskCache.put(key, new Integer(value));
    }
    /**
     * 设置long类型的值
     * @param key 键
     * @param value 值
     */
    public static void putLong(String key, long value) {
        Share.memoryCache.put(key, new Long(value));
        Share.diskCache.put(key, new Long(value));
    }
    /**
     * 设置boolean类型的值
     * @param key 键
     * @param value 值
     */
    public static void putBoolean(String key, boolean value) {
        Share.memoryCache.put(key, new Boolean(value));
        Share.diskCache.put(key, new Boolean(value));
    }
    /**
     * 设置String类型的值
     * @param key 键
     * @param value 值
     */
    public static void putString(String key, String value) {
        Share.memoryCache.put(key, value);
        Share.diskCache.put(key, value);
    }
    /**
     * 设置float类型的值
     * @param key 键
     * @param value 值
     */
    public static void putFloat(String key, float value) {
        Share.memoryCache.put(key, new Float(value));
        Share.diskCache.put(key, new Float(value));
    }
    /**
     * 设置double类型的值
     * @param key 键
     * @param value 值
     */
    public static void putDouble(String key, double value) {
        Share.memoryCache.put(key, new Double(value));
        Share.diskCache.put(key, new Double(value));
    }
    /**
     * 设置Object类型的值
     * @param key 键
     * @param value 值
     */
    public static void putObject(String key, Object value) {
        Share.memoryCache.put(key, value);
        Share.diskCache.put(key, value);
    }

    /**
     * 设置bytes类型的值
     * @param key 键
     * @param bytes 值
     */
    public static void putBytes(String key, byte[] bytes) {
        Share.memoryCache.put(key, bytes);
        Share.diskCache.put(key, bytes);
    }
    /**
     * 设置Bitmap类型的值
     * @param key 键
     * @param value 值
     */
    public static void putBitmap(String key, Bitmap value) {
        Share.memoryCache.put(key, value);
        Share.diskCache.put(key, value);
    }


    /**
     * 得到int类型的值
     * @param key 键
     * @param defalut 默认值
     * @return int值
     */
    public static int getInt(String key, int defalut) {
        Integer value = memoryCache.getInt(key, defalut);
        if (value == null) {
            value = diskCache.getInt(key, defalut);
            return value.intValue();
        } else {
            return value.intValue();
        }

    }
    /**
     * 得到long类型的值
     * @param key 键
     * @param defalut 默认值
     * @return long值
     */
    public static long getLong(String key, long defalut) {
        Long value = memoryCache.getLong(key, defalut);
        if (value == null) {
            value = diskCache.getLong(key, defalut);
            return value.longValue();
        } else {
            return value.longValue();
        }
    }
    /**
     * 得到String类型的值
     * @param key 键
     * @return String值
     */
    public static String getString(String key) {
        String value = memoryCache.getString(key);
        if (value == null) {
            return value = diskCache.getString(key);

        } else {
            return value;
        }
    }
    /**
     * 得到boolean类型的值
     * @param key 键
     * @param defalut 默认值
     * @return boolean值
     */
    public static boolean getBoolean(String key, boolean defalut) {
        Boolean value = memoryCache.getBoolean(key, defalut);
        if (value == null) {
            value = diskCache.getBoolean(key, defalut);
            return value.booleanValue();
        } else {
            return value.booleanValue();
        }
    }
    /**
     * 得到double类型的值
     * @param key 键
     * @param defalut 默认值
     * @return double值
     */
    public static double getDouble(String key, double defalut) {
        Double value = memoryCache.getDouble(key, defalut);
        if (value == null) {
            value = diskCache.getDouble(key, defalut);
            return value.doubleValue();
        } else {
            return value.doubleValue();
        }
    }
    /**
     * 得到float类型的值
     * @param key 键
     * @param defalut 默认值
     * @return float值
     */
    public static float getFloat(String key, float defalut) {
        Float value = memoryCache.getFloat(key, defalut);
        if (value == null) {
            value = diskCache.getFloat(key, defalut);
            return value.floatValue();
        } else {
            return value.floatValue();
        }
    }
    /**
     * 得到object类型的值
     * @param key 键
     * @return object值
     */
    public static Object getObject(String key) {
        Object object = memoryCache.getObject(key);
        if (object == null) {
            object = diskCache.getObject(key);
            return object;
        } else {
            return object;
        }
    }
    /**
     * 得到bytes类型的值
     * @param key 键
     * @return bytes值
     */

    public static byte[] getBytes(String key) {
        byte[] bytes = memoryCache.getBytes(key);
        if (bytes == null) {
            bytes = diskCache.getBytes(key);
        }
        return bytes;
    }
    /**
     * 得到Bitmap类型的值
     * @param key 键
     * @return bitmap值
     */
    public static Bitmap getBitmap(String key) {
        Bitmap bitmap = memoryCache.getBitmap(key);
        if (bitmap == null) {
            bitmap = diskCache.getBitmap(key);
        }
        return bitmap;
    }

}
