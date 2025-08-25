# 🚀 Build Instructions - 90+ Quiz App

## 📁 **Project Structure**

Dự án Android nằm ở thư mục gốc: `AndroidStudioProjects/90plusquiz/`

**KHÔNG** build từ thư mục `app/` - hãy build từ thư mục gốc dự án.

## 🔧 **Để Build Dự Án:**

### **1. Mở đúng thư mục dự án:**
```bash
cd AndroidStudioProjects/90plusquiz/
```

### **2. Kiểm tra Gradle wrapper:**
```bash
# Trên Linux/Mac
ls -la gradlew
./gradlew --version

# Trên Windows
dir gradlew.bat
gradlew --version
```

### **3. Sync Gradle:**
```bash
# Trên Linux/Mac
./gradlew clean
./gradlew build

# Trên Windows
gradlew clean
gradlew build
```

### **4. Hoặc sử dụng Android Studio:**
- Mở Android Studio
- Chọn "Open an existing project"
- Chọn thư mục `AndroidStudioProjects/90plusquiz/`
- Đợi Gradle sync hoàn tất

## ⚠️ **Vấn đề đã được sửa:**

1. ✅ **Thêm `include(":app")` vào `settings.gradle.kts`**
2. ✅ **Cập nhật plugins trong `app/build.gradle.kts` để sử dụng version catalog**
3. ✅ **Đảm bảo cấu trúc dự án đúng**
4. ✅ **Tạo scripts sửa Gradle wrapper**

## 🚨 **Nếu gặp lỗi "Task 'wrapper' not found":**

### **Giải pháp 1: Sử dụng script tự động**
```bash
# Trên Linux/Mac
chmod +x fix_gradle.sh
./fix_gradle.sh

# Trên Windows
fix_gradle.bat
```

### **Giải pháp 2: Sửa thủ công**
```bash
# 1. Đảm bảo đang ở thư mục gốc dự án
cd AndroidStudioProjects/90plusquiz/

# 2. Làm cho gradlew có quyền thực thi (Linux/Mac)
chmod +x gradlew

# 3. Refresh Gradle wrapper
./gradlew wrapper --gradle-version 8.11.1

# 4. Clean và build
./gradlew clean
./gradlew build
```

### **Giải pháp 3: Sử dụng Gradle trực tiếp**
```bash
# Nếu có Gradle installed globally
gradle clean
gradle build

# Hoặc sử dụng version cụ thể
gradle-8.11.1 clean
gradle-8.11.1 build
```

## 📋 **Cấu trúc thư mục đúng:**

```
AndroidStudioProjects/
└── 90plusquiz/                    ← Thư mục dự án gốc
    ├── app/                       ← Module app
    ├── gradle/                    ← Gradle wrapper
    ├── build.gradle.kts          ← Root build file
    ├── settings.gradle.kts       ← Project settings
    ├── gradlew                   ← Gradle wrapper script (Linux/Mac)
    ├── gradlew.bat               ← Gradle wrapper script (Windows)
    ├── fix_gradle.sh             ← Fix script (Linux/Mac)
    ├── fix_gradle.bat            ← Fix script (Windows)
    └── gradlew                   ← Gradle wrapper script
```

## 🎯 **Lệnh build từ terminal:**

```bash
# Từ thư mục gốc dự án
cd AndroidStudioProjects/90plusquiz/

# Kiểm tra tasks có sẵn
./gradlew tasks

# Clean và build
./gradlew clean
./gradlew build

# Hoặc build APK
./gradlew assembleDebug

# Hoặc build release
./gradlew assembleRelease

# Hoặc install trực tiếp
./gradlew installDebug
```

## 🔍 **Troubleshooting chi tiết:**

### **1. Kiểm tra thư mục hiện tại:**
```bash
pwd  # Linux/Mac
cd   # Windows
# Phải là: .../AndroidStudioProjects/90plusquiz/
```

### **2. Kiểm tra file settings.gradle.kts:**
```kotlin
rootProject.name = "90plus-quiz"
include(":app")  // ← Phải có dòng này
```

### **3. Kiểm tra Gradle wrapper:**
```bash
# Kiểm tra version
./gradlew --version

# Kiểm tra tasks
./gradlew tasks

# Kiểm tra projects
./gradlew projects
```

### **4. Sync Gradle trong Android Studio:**
- File → Sync Project with Gradle Files
- Hoặc click vào icon "Sync Now"
- Hoặc View → Tool Windows → Gradle

## 📱 **Chạy ứng dụng:**

1. **Kết nối thiết bị Android hoặc khởi động emulator**
2. **Chạy từ Android Studio:**
   - Click nút "Run" (▶️)
   - Hoặc Shift + F10

3. **Chạy từ terminal:**
   ```bash
   ./gradlew installDebug
   ```

## 🎉 **Kết quả mong đợi:**

- ✅ Gradle sync thành công
- ✅ Build thành công
- ✅ App chạy được trên thiết bị/emulator
- ✅ UI mới đẹp với animations

## 🆘 **Nếu vẫn gặp vấn đề:**

1. **Xóa thư mục .gradle và build:**
   ```bash
   rm -rf .gradle build app/build
   ```

2. **Refresh Gradle wrapper:**
   ```bash
   ./gradlew wrapper --gradle-version 8.11.1
   ```

3. **Invalidate caches trong Android Studio:**
   - File → Invalidate Caches and Restart

4. **Kiểm tra Java version:**
   ```bash
   java -version
   # Phải là Java 11 hoặc 17
   ```

---

**Lưu ý:** Luôn build từ thư mục gốc dự án `AndroidStudioProjects/90plusquiz/`, không phải từ `app/`!
