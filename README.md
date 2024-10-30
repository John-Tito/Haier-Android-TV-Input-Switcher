# 项目简介

## 项目名称

Haier Android TV Input Switcher

## 项目描述

本项目是一个简单的Android应用程序，用于切换海尔电视的输入源（HDMI/ATV/DTV）。通过特定的按键事件触发，可以启动海尔电视内置应用，从而实现输入源的切换。

## 主要功能

- **按键监听**：监听特定的按键事件，当检测到该按键被按下时，触发输入源切换。
- **启动目标应用**：通过Intent启动海尔电视内置应用中的指定Activity，实现输入源的切换。

## 使用方法

1. 将项目导入Android Studio。
2. 连接海尔电视设备或使用模拟器。
3. 编译并运行项目。
4. 按下特定的按键（如TV/HDMI键）或点击界面上的按钮，即可触发输入源切换。

## 测试设备

- **型号**: HRA920L_1G_WF/Haier-MM-920/海尔LE42C3
- **系统**: Android 5.1.0

## 注意事项

1. 确保海尔电视设置应用（`com.haier.tv.menusetting`）已安装在目标设备上。
2. 目标应用的包名或Activity名称（`com.haier.tv.menusetting.RootActivity`）可能不同。
3. 目标设备的遥控按键键值可能不同（`KEYCODE_HAIER_SOURCE=2002`）。
4. 目标设备可能提供了标准的TIF或类似的框架，这种情况该APP不适用，但实现逻辑基本相似：
   - 具体讨论见 [android-tv-hdmi/234411/37](https://community.home-assistant.io/t/android-tv-hdmi/234411/37?page=1)
   - 可以使用adb进行测试：
     ```bash
     # example 1
     adb shell am start -a android.intent.action.VIEW -d content://android.media.tv/passthrough/com.droidlogic.tvinput%2F.services.ATVInputService%2FHW0
     # example 2
     adb shell am start -a android.intent.action.VIEW -d content://com.tcl.tvpassthrough/.TvPassThroughService/HW1413744128 -n com.tcl.tv/.TVActivity -f 0x10000000
     ```

希望本项目能对您有所帮助！