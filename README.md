Nhiệm vụ
Thiết kế lại màn hình Home của ứng dụng di động “90+ Quiz” theo phong cách dark mode hiện đại, thể thao, tinh gọn, dễ đọc và nhất quán. Dựa trên ảnh gốc đính kèm (hiện có thanh tiêu đề, banner update, thống kê ✓/✗, tiêu đề hướng dẫn chọn game và 3 thẻ trò chơi).

Thiết bị & khung lưới

Kích thước khung thiết kế: Android 1080×2400 px (tỷ lệ 20:9).

Lưới: 12 cột, gutter 16 px, margin hai bên 24 px.

Khoảng cách dọc theo thang 8: 8/12/16/24/32/40 px.

Nhận diện & màu sắc (Design tokens)

Nền app: #0B1220 (dark-900).

Bề mặt/Surface card: #111827 (dark-800).

Viền mềm: #1F2937 (dark-700), opacity 60%.

Primary-Blue (cho “Quiz”, nút, highlight): #3B82F6.

Accent-Yellow (cho “90+”, badge NEW): #F6C12A.

Trạng thái: Green #22C55E (✓ thắng), Red #EF4444 (✗ thua).

Chữ chính: #E5E7EB (high), chữ phụ: #9CA3AF (medium).

Focus ring: xanh dương 24% alpha. Tất cả cặp màu đạt contrast ≥ 4.5:1.

Typography

Font: Inter hoặc Roboto.

Hệ thống chữ:

App Title (H1): 28–32 px, Bold.

Section Title (H2): 20–22 px, Semibold.

Card Title: 18 px, Semibold.

Body/Description: 14–16 px, Regular.

Badge/Meta: 12–13 px, Medium.

Không để chữ bị tách dòng bất thường (ví dụ “PL / AY”). Thiết lập min-width và no-wrap cho nút.

Thành phần & bố cục cụ thể

AppBar/Top Bar

Nền trong suốt 6% trên dark hoặc màu #0B1220.

Trái: Logo chữ “90+ (vàng) Quiz” (xanh) – sử dụng font tiêu đề, kerning chặt vừa.

Phải: icon profile hình tròn 32 px, có trạng thái bấm (ripple) rõ ràng.

Padding ngang 24 px, cao 56–64 px; shadow nhẹ (y=10, blur=30, opacity 12%).

Banner cập nhật (Update)

Card bo góc 20 px, viền #1F2937, nền #0F172A.

Trái: icon mũi tên cập nhật/rocket 24 px.

Nội dung: “New update available” (16 px, Medium) + link “Click here to update” (16 px, Semibold, màu Primary-Blue, có underline khi focus).

Phải: nút “Update” (mặc định mờ), text button hoặc ghost button.

Có nút đóng (×) 20 px; banner thu gọn sau khi cập nhật hoặc người dùng bấm đóng; ép chiều cao tối đa 88 px.

Khoảng cách với AppBar: 16 px.

Hàng thống kê thắng/thua

Căn trái dưới banner, khoảng cách 16 px.

Ô ✓ Wins: icon check, số 5 (Semibold 18 px) màu Green; Ô ✗ Losses: icon close, số 2 màu Red.

Bọc trong pill nền #111827, bo góc 14 px, padding ngang 12 px, khoảng cách giữa 2 pill 10–12 px.

Có tooltip giải thích (Wins/Losses today). Hỗ trợ đếm lớn (ví dụ 100+) với auto-width.

Tiêu đề phần chọn game

Dòng chữ: “Select the football game you want to play:”

Căn giữa khối nội dung, H2 20–22 px, Semibold, margin-top 16 px, margin-bottom 16–20 px.

Tránh tràn dòng > 2 lines; dùng max-width 85% màn hình.

Danh sách 3 thẻ trò chơi (Cards)

Bố cục 3 card xếp dọc (mobile), giữa mỗi card cách 16–20 px.

Mỗi card: kích thước tối thiểu (full width – 48 px), min-height 160–180 px, nền surface, bo góc 24 px, elevation nhẹ (shadow y=12, blur=40, 12%).

Cấu trúc card (trên→dưới):
a. Icon minh họa (bóng, áo đấu, sân cỏ…) 32–40 px, góc trái trên.
b. Card Title (18 px, Semibold) — ví dụ:

“Find Football Player”

“Football Vocabulary Game”

“Team Builder” (kèm badge “NEW” màu vàng #F6C12A, chữ 11–12 px, Bold, pill bo 10 px).
c. Mô tả ngắn 14–16 px, tối đa 2 dòng, auto-ellipsis:

“Guess the player from teammate clues.”

“Daily player crossword puzzle.”

“Build a team that fits constraints.”
d. Khu vực CTA:

Nút chính “Play” (không để thành “PL / AY”), height 44–48 px, min-width 96–120 px, bo góc 14–16 px, Primary-Blue nền đặc, chữ white, letter-spacing 0.

Trạng thái: Default / Pressed (90%) / Disabled (60%) / Focus (ring xanh 2 px).

Nút đặt bên phải theo hàng ngang với tiêu đề, hoặc dưới mô tả nếu mô tả dài; luôn giữ không bể chữ trên mọi độ rộng.

Tương tác card: chạm vào vùng card = mở game; chạm CTA = hành động “Play”. Có ripple 12–16% alpha.

Khoảng cách & căn chỉnh

Tất cả text căn theo baseline; lề trái của icon + title + mô tả thẳng hàng.

Không để bất kỳ từ nào bị chia đôi theo chiều dọc; ưu tiên wrap theo khoảng trắng.

Auto layout linh hoạt để nội dung tiếng khác (EN/VI/ES) không vỡ bố cục.

Trạng thái & tình huống đặc biệt

Loading: skeleton cho 3 card (3 thanh title + 2 dòng body giả).

Empty state: nếu chưa có số liệu wins/losses, hiển thị “Let’s play your first game!” cùng icon cúp.

Error: banner đỏ nhạt với icon cảnh báo, mô tả ngắn + nút “Retry”.

Offline: badge “Offline mode” màu xám, nút Play vẫn hoạt động nếu game không cần mạng.

Chuyển động (Motion)

Fade+slide cho banner update (150–200 ms).

Hover/Press card scale 0.98 khi nhấn (120 ms, ease-out).

Nút Play có micro-bounce nhẹ khi xuất hiện (120 ms).

Easing: standard, decelerate theo Material.

Khả dụng & truy cập (A11y)

Mục tiêu chạm ≥ 48×48 px.

Hỗ trợ Dynamic Type (phóng to 120%) không vỡ layout.

Label cho TalkBack: “Play Find Football Player”, “Play Team Builder (New)”,…

Color-blind friendly (không chỉ màu: thêm icon ✓/✗).

Biểu tượng & hình ảnh

Ưu tiên Material Symbols Rounded hoặc bộ icon thể thao nhất quán.

Icon đơn sắc, opacity 80–100% tùy cấp độ nổi bật.

Tránh ảnh bitmap nặng; nếu dùng, bo góc theo card.

Văn bản UI (gợi ý chuẩn hóa)

AppBar: “90+ Quiz” (90+ vàng, Quiz xanh).

Banner: “New update available — Click to update”.

Section: “Select the football game you want to play”.

Cards:

Find Football Player — “Guess the player from teammate hints.”

Football Vocabulary Game — “Daily football crossword.”

Team Builder — “Build a team under constraints.” (Badge NEW).

Kết quả mong muốn

01 khung high-fidelity mockup 1080×2400 px + style tokens (màu, text, radius, shadow).

Xuất thêm biến thể khoảng cách (compact/comfortable).

Bàn giao: file/ảnh mockup + bảng màu + thông số spacing/typography/radius, sẵn sàng cho dev Android/Flutter/Compose.

Tiêu chí chấp nhận

Không còn hiện tượng tách chữ “PL / AY”; bố cục sạch, đồng đều.

Contrast đạt chuẩn; icon/typography nhất quán; các card dễ quét nội dung.

Banner update gọn, không lấn át; số ✓/✗ rõ ràng, cân đối với tiêu đề phần.

Thẩm mỹ thể thao, hiện đại, phù hợp brand 90+ Quiz.
