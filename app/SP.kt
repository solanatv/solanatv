package io.solanatv.app


import android.content.Context
import android.content.SharedPreferences

object SP {
    // If Change channel with up and down in reversed order or not
    private const val KEY_CHANNEL_REVERSAL = "channel_reversal"

    // If use channel num to select channel or not
    private const val KEY_CHANNEL_NUM = "channel_num"

    private const val KEY_TIME = "time"

    // If start app on device boot or not
    private const val KEY_BOOT_STARTUP = "boot_startup"

    // Position in list of the selected channel item
    private const val KEY_POSITION = "position"

    private const val KEY_POSITION_GROUP = "position_group"

    private const val KEY_POSITION_SUB = "position_sub"

    private const val KEY_REPEAT_INFO = "repeat_info"

    private const val KEY_CONFIG = "config"

    private const val KEY_CONFIG_AUTO_LOAD = "config_auto_load"

    private const val KEY_CHANNEL = "channel"

    private const val KEY_DEFAULT_LIKE = "default_like"

    private const val KEY_DISPLAY_SECONDS = "display_seconds"

    private const val KEY_SHOW_ALL_CHANNELS = "show_all_channels"

    private const val KEY_COMPACT_MENU = "compact_menu"

    private const val KEY_LIKE = "like"

    private const val KEY_PROXY = "proxy"

    private const val KEY_EPG = "epg"

    private const val KEY_VERSION = "version"

    private const val KEY_LOG_TIMES = "log_times"

    const val DEFAULT_CONFIG_URL = ""
    const val DEFAULT_EPG = "https://epg.pw/xmltv/epg.xml"
    const val DEFAULT_CHANNEL = 0
    const val DEFAULT_SHOW_ALL_CHANNELS = false
    const val DEFAULT_COMPACT_MENU = true
    const val DEFAULT_DISPLAY_SECONDS = false
    const val DEFAULT_LOG_TIMES = 10
    const val DEFAULT_POSITION_GROUP = 1
    const val DEFAULT_POSITION = 0

    private lateinit var sp: SharedPreferences

    /**
     * The method must be invoked as early as possible(At least before using the keys)
     */
    fun init(context: Context) {
        sp = context.getSharedPreferences(
            context.getString(R.string.app_name),
            Context.MODE_PRIVATE
        )
    }

    var channelReversal: Boolean
        get() = sp.getBoolean(KEY_CHANNEL_REVERSAL, false)
        set(value) = sp.edit().putBoolean(KEY_CHANNEL_REVERSAL, value).apply()

    var channelNum: Boolean
        get() = sp.getBoolean(KEY_CHANNEL_NUM, true)
        set(value) = sp.edit().putBoolean(KEY_CHANNEL_NUM, value).apply()

    var time: Boolean
        get() = sp.getBoolean(KEY_TIME, true)
        set(value) = sp.edit().putBoolean(KEY_TIME, value).apply()

    var bootStartup: Boolean
        get() = sp.getBoolean(KEY_BOOT_STARTUP, false)
        set(value) = sp.edit().putBoolean(KEY_BOOT_STARTUP, value).apply()

    var positionGroup: Int
        get() = sp.getInt(KEY_POSITION_GROUP, DEFAULT_POSITION_GROUP)
        set(value) = sp.edit().putInt(KEY_POSITION_GROUP, value).apply()

    var position: Int
        get() = sp.getInt(KEY_POSITION, DEFAULT_POSITION)
        set(value) = sp.edit().putInt(KEY_POSITION, value).apply()

    var positionSub: Int
        get() = sp.getInt(KEY_POSITION_SUB, 0)
        set(value) = sp.edit().putInt(KEY_POSITION_SUB, value).apply()

    var repeatInfo: Boolean
        get() = sp.getBoolean(KEY_REPEAT_INFO, true)
        set(value) = sp.edit().putBoolean(KEY_REPEAT_INFO, value).apply()

    var config: String?
        get() = sp.getString(KEY_CONFIG, DEFAULT_CONFIG_URL)
        set(value) = sp.edit().putString(KEY_CONFIG, value).apply()

    var configAutoLoad: Boolean
        get() = sp.getBoolean(KEY_CONFIG_AUTO_LOAD, false)
        set(value) = sp.edit().putBoolean(KEY_CONFIG_AUTO_LOAD, value).apply()

    var channel: Int
        get() = sp.getInt(KEY_CHANNEL, DEFAULT_CHANNEL)
        set(value) = sp.edit().putInt(KEY_CHANNEL, value).apply()

    var compactMenu: Boolean
        get() = sp.getBoolean(KEY_COMPACT_MENU, DEFAULT_COMPACT_MENU)
        set(value) = sp.edit().putBoolean(KEY_COMPACT_MENU, value).apply()

    var showAllChannels: Boolean
        get() = sp.getBoolean(KEY_SHOW_ALL_CHANNELS, DEFAULT_SHOW_ALL_CHANNELS)
        set(value) = sp.edit().putBoolean(KEY_SHOW_ALL_CHANNELS, value).apply()

    var defaultLike: Boolean
        get() = sp.getBoolean(KEY_DEFAULT_LIKE, false)
        set(value) = sp.edit().putBoolean(KEY_DEFAULT_LIKE, value).apply()

    var displaySeconds: Boolean
        get() = sp.getBoolean(KEY_DISPLAY_SECONDS, DEFAULT_DISPLAY_SECONDS)
        set(value) = sp.edit().putBoolean(KEY_DISPLAY_SECONDS, value).apply()

    fun getLike(id: Int): Boolean {
        val stringSet = sp.getStringSet(KEY_LIKE, emptySet())
        return stringSet?.contains(id.toString()) ?: false
    }

    fun setLike(id: Int, liked: Boolean) {
        val stringSet = sp.getStringSet(KEY_LIKE, emptySet())?.toMutableSet() ?: mutableSetOf()
        if (liked) {
            stringSet.add(id.toString())
        } else {
            stringSet.remove(id.toString())
        }

        sp.edit().putStringSet(KEY_LIKE, stringSet).apply()
    }

    fun deleteLike() {
        sp.edit().remove(KEY_LIKE).apply()
    }

    var proxy: String?
        get() = sp.getString(KEY_PROXY, "")
        set(value) = sp.edit().putString(KEY_PROXY, value).apply()

    var epg: String?
        get() = sp.getString(KEY_EPG, DEFAULT_EPG)
        set(value) = sp.edit().putString(KEY_EPG, value).apply()

    var version: String?
        get() = sp.getString(KEY_VERSION, "")
        set(value) = sp.edit().putString(KEY_VERSION, value).apply()

    var logTimes: Int
        get() = sp.getInt(KEY_LOG_TIMES, DEFAULT_LOG_TIMES)
        set(value) = sp.edit().putInt(KEY_LOG_TIMES, value).apply()
}