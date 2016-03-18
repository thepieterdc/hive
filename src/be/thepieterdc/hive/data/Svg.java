package be.thepieterdc.hive.data;

import javafx.scene.shape.SVGPath;

/**
 * Enum that contains all svg vectors used in the program.
 * <p>
 * Created at 16/03/16 9:51
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public enum Svg {
	HEXAGON("M 31,9 L 15.5,0 0,9 0,27 15.5,36 31,27 L 31,9 z"),

	MOVEBUTTON_BEGIN("m17.029 1650.6q0.1852-0.1852 0.31192-0.1268 0.12672 0.059 0.12672 0.312v14.348q0 0.2535-0.12672 0.312-0.12672 0.058-0.31192-0.1268l-6.9206-6.9206q-0.08773-0.088-0.12672-0.1852v6.9206q0 0.2535-0.12672 0.312-0.12672 0.058-0.31192-0.1268l-6.9206-6.9206q-0.087726-0.088-0.12672-0.1852v6.6087q0 0.2535-0.1852 0.4387t-0.43863 0.1852h-1.2478q-0.25343 0-0.43863-0.1852-0.18517-0.1-0.18517-0.4v-13.724q0-0.2535 0.1852-0.4387t0.43863-0.1852h1.2477q0.25343 0 0.43863 0.1852t0.1852 0.4387v6.6087q0.038989-0.1073 0.12672-0.1852l6.9206-6.9206q0.1852-0.1852 0.31192-0.1268 0.12672 0.059 0.12672 0.312v6.9206q0.038989-0.1073 0.12672-0.1852z"),
	MOVEBUTTON_END("m0.43863 1665.3q-0.1852 0.1852-0.31192 0.1268-0.12671 0-0.12671-0.3v-14.348q0-0.2535 0.12672-0.312 0.12672-0.058 0.31192 0.1268l6.9206 6.9206q0.077979 0.078 0.12672 0.1852v-6.9206q0-0.2535 0.12672-0.312 0.12672-0.058 0.31192 0.1268l6.9206 6.9206q0.07798 0.078 0.12672 0.1852v-6.6087q0-0.2535 0.1852-0.4387t0.43863-0.1852h1.2477q0.25343 0 0.43863 0.1852t0.1852 0.4387v13.724q0 0.2535-0.1852 0.4387t-0.43863 0.1852h-1.2477q-0.25343 0-0.43863-0.1852t-0.1852-0.4387v-6.6087q-0.04874 0.097-0.12672 0.1852l-6.9206 6.9206q-0.1852 0.1852-0.31192 0.1268-0.12672-0.058-0.12672-0.312v-6.9206q-0.048737 0.097-0.12672 0.1852z"),
	MOVEBUTTON_NEXT("m64.439 1665.3q-0.1852 0.1852-0.31192 0.1268-0.127 0-0.127-0.3v-14.348q0-0.2535 0.12672-0.312 0.12672-0.058 0.31192 0.1268l6.9206 6.9206q0.07798 0.078 0.12672 0.1852v-6.9206q0-0.2535 0.12672-0.312 0.12672-0.058 0.31192 0.1268l6.9206 6.9206q0.1852 0.1852 0.1852 0.4386t-0.1852 0.4386l-6.9206 6.9206q-0.1852 0.1852-0.31192 0.1268-0.12672-0.058-0.12672-0.312v-6.9206q-0.04874 0.097-0.12672 0.1852z"),
	MOVEBUTTON_PLAY("m205.37 1665.1-12.829 7.1295q-0.22219 0.1256-0.38159 0.029-0.16 0-0.16-0.2v-14.22q0-0.2512 0.1594-0.3478 0.1594-0.097 0.38159 0.029l12.829 7.1295q0.22219 0.1256 0.22219 0.2995t-0.22219 0.2995z"),
	MOVEBUTTON_PREVIOUS("m200.59 1650.6q0.1852-0.1852 0.31192-0.1268 0.12671 0.059 0.12671 0.312v14.348q0 0.2535-0.12671 0.312-0.12672 0.058-0.31192-0.1268l-6.9206-6.9206q-0.078-0.088-0.12671-0.1852v6.9206q0 0.2535-0.12672 0.312-0.12671 0.058-0.31191-0.1268l-6.9206-6.9206q-0.18-0.2-0.18-0.5 0-0.2534 0.1852-0.4386l6.9206-6.9206q0.1852-0.1852 0.31191-0.1268 0.12672 0.059 0.12672 0.312v6.9206q0.0487-0.1073 0.12671-0.1852z"),
	MOVEBUTTON_STOP("m143 1649.6v13.75q0 0.2539-0.18555 0.4395-0.18 0.2-0.43 0.2h-13.75q-0.25391 0-0.43945-0.1855-0.19-0.2-0.19-0.4v-13.75q0-0.2539 0.18555-0.4395 0.18-0.2 0.43-0.2h13.75q0.25391 0 0.43945 0.1855 0.19 0.2 0.19 0.4z"),

	UNIT_ANT("m8.2639 172.62c-0.39843-0.3248-0.73105-0.73327-0.95743-1.1758-0.32646-0.63814-0.34689-0.75684-0.34689-2.015 0-1.6952 0.07507-2.03 0.64738-2.887 0.25652-0.38414 0.42973-0.75778 0.38491-0.8303-0.12748-0.20626-1.6378-0.0642-2.2626 0.21274-0.67743 0.30036-1.2314 0.85581-2.1635 2.1693-1.0934 1.5409-2.1324 2.8188-2.296 2.8241-0.3984 0.0128 0.13208-0.89141 1.3597-2.3177 0.40053-0.46537 1.0079-1.2752 1.3497-1.7996 0.34182-0.52441 0.68435-0.99269 0.76116-1.0406 0.076814-0.0479 0.7895-0.21864 1.5837-0.37935l1.4441-0.29219-0.02452-0.51987c-0.013484-0.28593-0.085055-0.77265-0.15904-1.0816-0.12249-0.51147-0.18231-0.58317-0.66864-0.8014-0.37112-0.16654-0.78091-0.24106-1.3428-0.24418-0.98447-0.005-1.2631 0.12771-3.0102 1.4389-1.5699 1.1782-2.3727 1.6487-2.533 1.4846-0.15311-0.15682 0.26012-0.4965 1.6731-1.3753 0.60363-0.37542 1.4614-0.97579 1.9062-1.3342l0.80869-0.65156 0.86645 0.0655c0.47655 0.036 1.1573 0.0996 1.5129 0.14135 0.54537 0.064 0.65818 0.0452 0.72163-0.1201 0.16005-0.41708-0.10988-0.59308-1.3262-0.86464-1.5464-0.34528-1.687-0.41836-2.0031-1.0416-0.14671-0.28919-0.74652-1.1756-1.3329-1.9699-1.1146-1.5097-1.3579-1.9137-1.2297-2.0419 0.14255-0.14255 0.67241 0.47435 1.5553 1.8109 1.2247 1.8539 1.4739 2.1556 2.0671 2.5033 0.61983 0.36325 1.6954 0.63534 2.0268 0.51275 0.13996-0.0518 0.40679-0.43624 0.65316-0.94111 0.47699-0.97744 0.84094-1.2695 1.3562-1.0883 0.3066 0.10782 0.55431 0.4933 1.0821 1.684l0.17329 0.39092 0.80869-0.009c0.63781-0.007 0.93607-0.0741 1.4115-0.31778 0.63065-0.32322 0.81586-0.53815 2.2573-2.6194 0.93421-1.3488 1.4236-1.9317 1.5325-1.8249 0.17839 0.17485-0.09457 0.66259-1.0536 1.8827-0.5494 0.69893-1.1536 1.544-1.3427 1.8778-0.4432 0.78256-0.76268 1.0242-1.5701 1.1877-0.36149 0.0732-0.90496 0.18466-1.2077 0.24772-0.50402 0.10499-0.89629 0.34086-0.89188 0.53627 0.00092 0.0431 0.0461 0.14835 0.10029 0.23384 0.08198 0.12936 0.35187 0.13125 1.608 0.0113l1.5094-0.14414 0.61193 0.55018c0.33656 0.30259 1.1848 0.92794 1.885 1.3896 0.70017 0.46171 1.429 0.98717 1.6196 1.1677 0.30167 0.28567 0.31919 0.33376 0.1352 0.37107-0.25021 0.0508-1.0837-0.48376-2.701-1.7322-1.4482-1.1179-1.7492-1.2492-2.864-1.2492-1.1756 0-1.6238 0.19694-1.8971 0.83367-0.29228 0.68087-0.39231 1.4212-0.21045 1.5576 0.07899 0.0592 0.77625 0.22644 1.5495 0.37154 1.5659 0.29387 1.5738 0.29893 2.2665 1.4539 0.22863 0.38124 0.76957 1.1267 1.2021 1.6565 0.43253 0.52984 0.95537 1.2047 1.1619 1.4997 0.36744 0.5249 0.48521 0.94498 0.26492 0.94498-0.14193 0-1.1665-1.2815-2.032-2.5416-1.3756-2.0028-1.8085-2.3824-3.114-2.7311-0.73487-0.1963-1.5241-0.20257-1.5918-0.0126-0.028296 0.0794 0.11856 0.37881 0.32634 0.6653s0.4921 0.85835 0.63183 1.2708c0.21725 0.6413 0.24626 0.92558 0.20033 1.9629-0.06981 1.5766-0.25083 2.0075-1.2141 2.8902-0.41486 0.38015-0.82281 0.69118-0.90655 0.69118s-0.427-0.22396-0.76279-0.4977zm1.6887-0.88618c0.21348-0.2117 0.21404-0.23854 0.018132-0.86141-0.21618-0.6873-0.39846-0.79448-0.66596-0.39161-0.2302 0.34671-0.50987 0.20875-0.67212-0.33154-0.20093-0.66912-0.27065-2.0031-0.13111-2.5085 0.14429-0.52259 0.053558-0.77834-0.16843-0.47475-0.10694 0.14625-0.13331 0.46235-0.09058 1.0861 0.054326 0.79314-0.054158 2.1428-0.2475 3.0791-0.073262 0.3548 0.020644 0.4541 0.63972 0.67647 0.31141 0.11186 1.0926-0.0505 1.3179-0.27395zm-0.04374-3.9881c0.040699-0.40374 0.00124-0.51987-0.17661-0.51987-0.18085 0-0.2343 0.39975-0.10019 0.74924 0.086855 0.22635 0.24398 0.0961 0.27679-0.22937zm-0.3919-5.51c-0.039808-0.27004-0.10196-0.90689-0.13812-1.4152-0.086259-1.2127-0.13908-1.4441-0.32964-1.4441-0.21574 0-0.29898 0.25935-0.29898 0.93153 0 0.31132-0.062288 0.92928-0.13842 1.3732-0.14664 0.85515-0.096944 1.0577 0.19919 0.81197 0.15156-0.12578 0.21393-0.1189 0.37413 0.0413 0.31221 0.31221 0.40905 0.22503 0.33184-0.29874zm-2.5579-4.2564c-0.69001-0.65258-1.0778-0.79084-2.2302-0.7952-0.51369-0.002-0.70494-0.0415-0.64783-0.13387 0.05632-0.0911 0.47128-0.11261 1.3608-0.0704 1.0972 0.052 1.3003 0.0336 1.424-0.12882 0.13275-0.17445 0.14449-0.17365 0.14787 0.01 0.00602 0.32678 0.49497 0.57852 0.85661 0.44103 0.39162-0.14889 0.54742-0.56376 0.45765-1.2187-0.1405-1.0251-0.52177-1.0914-1.0932-0.1903-0.18307 0.28868-0.33286 0.49208-0.33286 0.45201 0-0.20513 0.26768-0.72531 0.56855-1.1049 0.18622-0.23492 0.42668-0.73905 0.53436-1.1203 0.28088-0.99444 0.57831-1.2978 0.65121-0.66428 0.026472 0.23005 0.11002 0.32811 0.30285 0.35545 0.34087 0.0483 0.63211-0.19189 0.56124-0.46291-0.03024-0.11563 0.00562-0.21024 0.079706-0.21024 0.18404 0 0.3782 0.33503 0.53794 0.92827 0.07357 0.27321 0.34804 0.80059 0.60993 1.172 0.33874 0.48034 0.49433 0.83319 0.53909 1.2226l0.06292 0.54736 1.4005-0.0417c0.94436-0.0281 1.4263 0.00009 1.4798 0.0866 0.05533 0.0895-0.19352 0.1325-0.82282 0.14203-1.3981 0.0212-1.5401 0.0757-1.9942 0.76614l-0.39888 0.60652h-1.7164-1.7164l-0.62211-0.58837zm4.0832-0.86116c0.17962-0.39423 0.16902-0.65346-0.04901-1.1984-0.1926-0.48135-0.65499-0.87567-0.91144-0.77726-0.25205 0.0967-0.3453 1.3692-0.13074 1.7841 0.29301 0.56663 0.87384 0.66857 1.0912 0.19152z"),
	UNIT_BEATLE("m2.2522 24.409c-0.005-0.6068-0.2905-1.22-0.85626-1.8391-0.19639-0.2149-0.35068-0.62728-0.44639-1.1931-0.22833-1.3498-0.20633-1.4823 0.28068-1.6908 0.23482-0.1005 0.49627-0.1799 0.581-0.17646 0.08473 0.003 0.1924-0.14896 0.23926-0.3387 0.04686-0.18973 0.22967-0.49693 0.40625-0.68265 0.22962-0.24153 0.37658-0.63433 0.51608-1.3794 0.10727-0.57292 0.23149-1.2042 0.27605-1.4029 0.07131-0.31797 0.04239-0.36125-0.24138-0.36125-0.27308 0-0.35962 0.10952-0.56579 0.71605-0.21238 0.6248-0.29171 0.72107-0.62247 0.75536-0.33142 0.0344-0.40964 0.12995-0.62227 0.76038-0.2914 0.86401-0.85507 1.4355-1.1374 1.1532-0.15404-0.15404-0.04336-0.46994 0.73803-2.1066 0.77832-1.6302 0.98515-1.9586 1.3492-2.1423 0.23648-0.11933 0.5915-0.3681 0.78895-0.5528 0.3378-0.316 0.37331-0.32287 0.60149-0.11637 0.63234 0.57226 0.73076 0.0301 0.15838-0.87246-0.21552-0.33984-0.42822-0.7628-0.47268-0.93992-0.04445-0.17711-0.28186-0.44064-0.52758-0.58562l-0.44675-0.26359 0.2626-0.66621c0.14443-0.36641 0.26259-0.89637 0.26259-1.1777 0-0.52069 0.84355-2.3697 1.1222-2.4597 0.0773-0.025 0.19241 0.32393 0.26437 0.80132l0.12745 0.84556-0.37825 0.0756c-0.33763 0.0675-0.36834 0.11446-0.28601 0.43712 0.05073 0.19881 0.07908 0.56837 0.063 0.82125-0.0813 1.2786-0.09471 1.2345 0.40094 1.3185 0.25288 0.0428 0.59279 0.15004 0.75536 0.23821 0.26116 0.14165 0.29558 0.12991 0.29558-0.10086 0-0.14365-0.06487-0.40355-0.14416-0.57756-0.11352-0.24915-0.09697-0.40764 0.07785-0.74571 0.32095-0.62064 0.16052-2.3905-0.26779-2.9543-0.16577-0.21821-0.57014-0.94977-0.8986-1.6257-0.71436-1.47-0.80973-1.5954-1.2137-1.5954-0.25946 0-0.31233-0.0667-0.31233-0.3941 0-0.37012 0.03099-0.3941 0.50931-0.3941 0.43575 0 0.66818-0.13069 1.6092-0.90486 0.60496-0.49767 1.2147-1.1024 1.355-1.3438l0.25509-0.4389 0.10369 0.40015c0.11449 0.44184 1.093 1.2364 1.5226 1.2364 0.33388 0 1.1402-0.59537 1.8401-1.3587 0.62361-0.68012 0.68697-0.71501 0.68697-0.37825 0 0.5106 0.94011 2.172 1.6504 2.9167l0.73265 0.76811-0.224 0.43824c-0.1232 0.24103-0.58217 1.059-1.0199 1.8176-0.43776 0.75865-1.0456 1.8706-1.3507 2.4709l-0.55476 1.0916 0.31749 0.14465c0.26474 0.12063 0.31749 0.23937 0.31749 0.71473 0 0.45869 0.04562 0.57006 0.2335 0.57006 0.68472 0 1.3352-1.0633 1.34-2.1904 0.0038-0.88441 0.26723-2.0134 0.46988-2.0134 0.09225 0 0.25036 0.42794 0.37616 1.0181 0.11936 0.55995 0.27534 1.275 0.34662 1.589 0.07128 0.31398 0.09048 0.86582 0.04266 1.2263l-0.08695 0.65544-0.44138-0.0828c-0.38203-0.0717-0.44138-0.0473-0.44138 0.18132 0 0.14526-0.18233 0.47177-0.40517 0.72558-0.32905 0.37477-0.38917 0.53434-0.31997 0.84937 0.13197 0.60086 0.35578 0.71228 1.2168 0.60572 0.41599-0.0515 0.82742-0.15191 0.91428-0.22318 0.15492-0.12711 0.81363 0.2291 0.8232 0.44516 0.0023 0.0513 0.16229 0.23986 0.3556 0.4191 0.25089 0.23264 0.47554 0.73228 0.78503 1.7459 0.23846 0.78102 0.43499 1.5439 0.43673 1.6952 0.0017 0.15137 0.1214 0.38221 0.2659 0.51299 0.35617 0.32233 0.33214 0.59115-0.05283 0.59115-0.23288 0-0.35175-0.1038-0.45365-0.3961-0.07594-0.21785-0.3773-0.67979-0.66968-1.0265-0.45296-0.53718-0.53161-0.71993-0.53161-1.2352 0-0.77462-0.09861-1.0204-0.40944-1.0204-0.13748 0-0.34604-0.11221-0.46348-0.24937-0.20734-0.24215-0.22564-0.23723-0.63319 0.17031-0.41568 0.41568-0.41838 0.42677-0.28326 1.1644 0.11621 0.63439 0.1915 0.76749 0.50838 0.89875 0.7531 0.31195 1.6695 1.7706 1.6775 2.67 0.0013 0.14969 0.20759 0.77035 0.45838 1.3792 0.25079 0.60889 0.4315 1.1316 0.4016 1.1615-0.12223 0.12223-0.65938-0.15563-1.1396-0.58951-0.38858-0.35105-0.51094-0.56106-0.51094-0.87688 0-0.22839-0.09784-0.55494-0.21741-0.72566-0.11958-0.17072-0.25478-0.49423-0.30044-0.71891-0.05791-0.2849-0.16879-0.42092-0.36647-0.44953-0.29412-0.0426-0.41161 0.22925-0.61396 1.4204-0.11366 0.66909-0.7638 1.9543-1.3005 2.5709-0.45892 0.5272-1.8369 1.3701-2.2398 1.3701-0.31023 0-0.46853-0.40233-0.63178-1.6057-0.08113-0.59805-0.1899-1.1353-0.24171-1.1938-0.05181-0.0586-0.1231 0.44594-0.15842 1.1211-0.07999 1.5293-0.23424 1.869-0.79735 1.7564-0.76418-0.15283-1.7596-0.70052-2.3052-1.2683-0.46442-0.48333-1.225-1.8371-1.6879-3.0043l-0.1266-0.31922-0.28639 0.28638c-0.23097 0.23097-0.28639 0.43973-0.28639 1.0788 0 0.43583 0.08867 1.0046 0.19705 1.264 0.2887 0.69097 0.2578 1.7825-0.06131 2.1656l-0.25836 0.31013-0.0049-0.59115zm6.9586-14.836c0-0.0682-0.21974-0.0892-0.49262-0.0471-0.68213 0.10526-0.70301 0.1702-0.05474 0.1702 0.30105 0 0.54736-0.0554 0.54736-0.12311zm-2.9672-0.0877c0.31063-0.1192 0.11376-0.31465-0.31692-0.31465-0.37899 0-0.59219 0.15222-0.43432 0.31009 0.106 0.10601 0.48094 0.10828 0.75124 0.005zm3.4215-3.9059c0.18367-0.31341 0.33395-0.60542 0.33395-0.6489 0-0.0435-0.21608-0.0974-0.48017-0.11983l-0.48017-0.0408 0.3488-0.41306c0.60032-0.71093 0.45517-1.0385-0.33642-0.75922-0.29156 0.10287-0.55743 0.18703-0.59082 0.18703s-0.02151-0.23203 0.0264-0.51563c0.05229-0.3095 0.02616-0.62953-0.06537-0.80055-0.15201-0.28404-0.15336-0.28412-0.43683-0.026-0.15639 0.14239-0.5208 0.33306-0.80981 0.4237-0.72485 0.22732-0.71664 0.21819-0.59064 0.65753 0.10289 0.35877 0.08521 0.39233-0.20673 0.39233-0.3573 0-0.42891 0.33783-0.17297 0.81606 0.12985 0.24262 0.1151 0.26516-0.13137 0.20071-0.17615-0.0461-0.27764-0.011-0.27764 0.0961 0 0.27314 0.30546 0.44841 0.79278 0.45487 0.25036 0.003 0.61859 0.0128 0.81829 0.0212 0.1997 0.008 0.51005-0.0218 0.68968-0.0668 0.26711-0.067 0.32659-0.0337 0.32659 0.18326 0 0.19363 0.08657 0.26524 0.32066 0.26524 0.17637 0 0.3572 0.0591 0.40185 0.13137 0.12533 0.20278 0.16248 0.17145 0.51993-0.43849z"),
	UNIT_GRASSHOPPER("m13.795 24.28c0-0.46159-0.1413-1.0851-0.36789-1.6235-0.35008-0.83175-0.37113-1.0534-0.43468-4.5767-0.08056-4.4662-0.18401-5.5649-0.524-5.5649-0.30503 0-1.6666 1.8606-1.8031 2.4639-0.0563 0.24894-0.07173 0.9864-0.03429 1.6388 0.07718 1.3447-0.1151 2.2474-0.60827 2.8555-0.18576 0.22907-0.46031 0.81873-0.6101 1.3104-0.42974 1.4105-1.0816 2.582-1.6189 2.9096-0.62172 0.37909-0.73778 0.37032-1.294-0.0977-0.57873-0.48697-0.92672-1.1728-1.2756-2.514-0.14922-0.57358-0.47744-1.3358-0.72939-1.6939-0.45516-0.64684-0.45809-0.66356-0.45809-2.6072v-1.9562l-0.68493-1.0429c-0.37671-0.57358-0.73589-1.177-0.79817-1.3408-0.0975-0.25655-0.14334-0.21514-0.3298 0.29797-0.26865 0.73926-0.46529 2.731-0.63248 6.4062-0.12437 2.7341-0.14458 2.8637-0.59212 3.799-0.25484 0.53261-0.46341 1.1488-0.46347 1.3693-0.000194 0.67496-0.25376 0.603-0.43682-0.12397-0.16042-0.63708-0.14598-0.72749 0.19598-1.2272 0.29138-0.42584 0.3897-0.80633 0.46665-1.8059 0.05362-0.69649 0.19233-1.9703 0.30824-2.8307 0.11591-0.86037 0.28078-2.1006 0.36637-2.7562 0.08559-0.65552 0.23208-1.6276 0.32553-2.1602 0.09345-0.53261 0.16029-1.6229 0.14853-2.4229-0.02003-1.3628-0.0043-1.4454 0.24929-1.3096 0.14887 0.0797 0.37192 0.29843 0.49567 0.48612s0.53074 0.5599 0.90442 0.82712c0.78056 0.55818 0.691 0.66362 1.0718-1.2618 0.24989-1.2637 0.16282-1.8312-0.28095-1.8312-0.10848 0-0.59218-0.20017-1.0749-0.44482-0.8098-0.41043-0.89215-0.42536-1.0653-0.19311-0.28023 0.37598-0.48105 1.2188-0.48198 2.023-0.000745 0.63742-0.049 0.742-0.44684 0.96838-0.2453 0.13959-0.44643 0.37111-0.44695 0.51451-0.0012 0.32499-0.20073 0.33506-0.45955 0.0232-0.16723-0.20151-0.15002-0.27493 0.11349-0.4842 0.17084-0.13566 0.39396-0.51483 0.49582-0.8426 0.1021-0.3283 0.3445-0.9799 0.5389-1.4486s0.3535-1.0141 0.3535-1.2121c0-0.19795 0.09667-0.54625 0.21483-0.774 0.24065-0.46386 0.18288-0.96371-0.23653-2.0464-0.15194-0.39225-0.27626-0.90014-0.27626-1.1286 0-0.24723-0.14646-0.55305-0.3617-0.75525-0.36985-0.34746-0.36706-0.75502 0.0052-0.75502 0.11414 0 0.20753 0.099 0.20753 0.22004 0 0.12102 0.1676 0.32985 0.37246 0.46408 0.3099 0.20305 0.37246 0.36172 0.37246 0.94478 0 1.0099 0.39402 2.2446 0.71626 2.2446 0.34178 0 2.4597-0.89054 2.5854-1.0871 0.05418-0.0847 0.14205-0.44432 0.19525-0.7991 0.0532-0.35479 0.26028-0.83943 0.46017-1.077 0.441-0.5242 0.4663-1.1056 0.0655-1.5064-0.4221-0.42213-1.1251-0.3739-2.0858 0.14311-0.9366 0.50409-1.0428 0.52969-1.0428 0.25139 0-0.26202 1.9051-1.1394 2.4742-1.1394 0.5858 0 1.0416 0.34169 1.4044 1.0527 0.40208 0.78814 0.91659 0.81217 1.2738 0.0595 0.13744-0.28963 0.39015-0.62484 0.56158-0.74491 0.67336-0.47164 1.9048-0.17276 3.0016 0.72854 0.57788 0.47487 0.38606 0.67394-0.2537 0.26329-1.6531-1.0611-2.366-1.1066-2.8297-0.1807-0.25135 0.5019-0.25039 0.50696 0.17132 0.90089 0.38864 0.36305 0.749 1.2292 0.75105 1.8052 0.000595 0.15545 0.40321 0.38793 1.1962 0.69064l1.1953 0.45631 0.21999-0.31409c0.15038-0.2147 0.21999-0.69887 0.21999-1.5302 0-1.123 0.02767-1.2342 0.36161-1.453 0.19889-0.13032 0.38325-0.36815 0.4097-0.52852 0.04383-0.26577 0.07446-0.27183 0.34605-0.0685 0.2962 0.22175 0.29598 0.22471-0.03725 0.49802-0.18436 0.15121-0.33521 0.43201-0.33521 0.62399 0 0.19197-0.13408 0.81791-0.29796 1.391-0.35815 1.2524-0.38415 1.9875-0.07449 2.1064 0.1255 0.0482 0.22347 0.26985 0.22347 0.50568 0 0.23096 0.26817 0.97446 0.59593 1.6522 0.32776 0.67777 0.59593 1.3169 0.59593 1.4204 0 0.10344 0.1823 0.35711 0.4051 0.56371 0.30888 0.28641 0.36378 0.41696 0.23112 0.54962-0.13266 0.13265-0.30851 0.0563-0.74031-0.32157-0.457-0.3994-0.584-0.6301-0.66-1.1942-0.051-0.3845-0.252-1.0421-0.447-1.4613l-0.35384-0.76219-1.2664 0.63943-1.2664 0.63943 0.02032 1.3667c0.01117 0.75168 0.06304 1.5369 0.11524 1.7449l0.09492 0.37819 0.91346-0.63584c0.5024-0.34971 1.0204-0.81978 1.1511-1.0446 0.47007-0.80855 0.6101-0.52107 0.6101 1.2525 0 1.7121 0.33877 6.0522 0.59832 7.6654 0.08062 0.50109 0.14659 1.5466 0.14659 2.3234 0 1.2231 0.03992 1.4484 0.29796 1.682 0.34324 0.31063 0.37075 0.69198 0.11808 1.6367-0.23711 0.88653-0.41605 0.85349-0.41605-0.0768zm-5.2371-2.742c0.08737-0.45647-0.38852-0.68027-1.4466-0.68027-1.0696 0-1.5336 0.25128-1.4009 0.75872 0.07079 0.27071 0.18822 0.29136 1.4347 0.25226 1.2055-0.0378 1.3638-0.0749 1.4128-0.33071zm0.05999-1.3125c0.47588-0.13614 0.55868-0.22214 0.55868-0.58034 0-0.41019-0.01583-0.41834-0.64466-0.33215l-0.64466 0.0884-0.19032-4.8214c-0.1047-2.653-0.2427-4.8786-0.3066-4.947-0.06396-0.0684-0.16233 0.63551-0.2186 1.5643-0.05627 0.92881-0.16398 2.2586-0.23936 2.9551-0.07538 0.69649-0.1376 1.9452-0.13828 2.7748-0.000745 0.82964-0.04441 1.7244-0.0972 1.9883-0.10143 0.50716-0.14866 0.51552-1.2076 0.21398-0.28594-0.0814-0.33521-0.0387-0.33521 0.29055 0 0.28408 0.12785 0.45306 0.48419 0.63994 0.93886 0.49238 1.6884 0.53372 2.9796 0.16434zm-1.3781-12.483c0-0.35778-0.08442-0.47996-0.4097-0.59296-0.22534-0.0783-0.6-0.24451-0.83259-0.3694-0.75607-0.40601-0.86314 0.0871-0.21784 1.0033 0.23141 0.32856 0.40459 0.4097 0.87435 0.4097 0.55262 0 0.58578-0.0255 0.58578-0.45063zm2.2648-0.21652c0.17827-0.36693 0.28846-0.70282 0.24486-0.74642s-0.40821 0.032-0.81026 0.16796c-0.40204 0.13598-0.81479 0.26864-0.91721 0.2948-0.10243 0.0262-0.18623 0.2508-0.18623 0.49919 0 0.43613 0.02307 0.45162 0.67236 0.45162 0.6488 0 0.68371-0.0234 0.99648-0.66715zm-4.6538-0.9619c0.08482-0.15849 0.15422-0.43255 0.15422-0.60902 0-0.29353-0.05393-0.31251-0.63318-0.22286-0.87919 0.13608-1.6016 0.37379-1.6016 0.52702 0 0.13154 1.2092 0.54949 1.6708 0.57752 0.14051 0.009 0.32488-0.11416 0.4097-0.27266zm6.6082-0.2473c0.384-0.1306 0.697-0.295 0.697-0.3654 0-0.1765-0.999-0.4381-1.676-0.4391-0.5776-0.0009-0.6321 0.082-0.465 0.7068 0.109 0.4049 0.471 0.4294 1.444 0.0977zm-3.5923-0.6502c-0.04985-0.76228-0.08279-0.82033-0.39708-0.69973-0.16112 0.0618-0.2299 0.29331-0.2299 0.77368 0 0.62563 0.02926 0.68131 0.33521 0.63785 0.29826-0.0424 0.33042-0.12083 0.29177-0.7118zm1.6552-0.006c0.06705-0.0606 0.10057-0.37035 0.07449-0.68843-0.04727-0.57655-0.04957-0.57845-0.75508-0.62372-0.67471-0.0433-0.70767-0.0273-0.70767 0.34261 0 0.2134 0.10267 0.58656 0.22816 0.82922 0.19354 0.37427 0.28961 0.42674 0.63318 0.34583 0.22276-0.0525 0.45987-0.14494 0.52692-0.20551zm-2.6092-0.6335c0.04467-0.69624 0.03824-0.70767-0.39906-0.70767-0.55572 0-0.9127 0.34407-0.9127 0.87971 0 0.54452 0.1125 0.63274 0.73959 0.57996 0.51549-0.0434 0.52773-0.0595 0.57217-0.752zm1.3413-1.1986 0.3212-0.3419-0.4414-0.2608c-0.49298-0.29122-0.91448-0.16982-1.1886 0.3423-0.2579 0.48189-0.17441 0.60231 0.41756 0.60231 0.40176 0 0.66476-0.10091 0.89119-0.34193z"),
	UNIT_QUEEN("m9.4865 24.887c0-0.062 0.25974-0.44803 0.57719-0.85782 0.42448-0.54793 0.64142-1.1456 0.81995-2.2589 0.13352-0.83259 0.32028-1.7863 0.41503-2.1193 0.30065-1.0567 1.4615-4.2325 1.6053-4.3917 0.07603-0.0842 0.84176 0.21103 1.7016 0.65599 1.3132 0.67957 1.7565 0.80901 2.77 0.80901 1.3194 0 2.3174-0.33704 3.3659-1.1368 0.37406-0.28531 0.70116-0.48686 0.7269-0.4479 0.52975 0.80201 1.9632 5.1335 2.1584 6.5222 0.14628 1.0406 0.36037 1.6452 0.80055 2.2608 0.67912 0.9498 0.71683 1.0771 0.31902 1.0771-0.59102 0-1.4779-1.3355-1.6944-2.5515-0.25773-1.4474-0.58942-2.3478-0.83201-2.2586-0.10003 0.0368-0.57632 0.65725-1.0584 1.3788-1.529 2.2886-3.6044 2.9477-5.7825 1.8366-1.054-0.53773-1.6695-1.3034-2.3671-2.9447l-0.57652-1.3565-0.37978 1.081c-0.20888 0.59452-0.45387 1.5434-0.54444 2.1086-0.19655 1.2266-0.67281 2.2132-1.2062 2.4986-0.42427 0.22706-0.81854 0.27285-0.81854 0.0951zm9.0649-2.8273c2.0553-0.61035 3.4797-2.644 3.0994-4.4251l-0.17197-0.80534-0.49754 0.90195c-0.63159 1.1449-1.2401 1.383-2.6266 1.0277-0.80832-0.20717-1.2054-0.212-1.8809-0.0229-1.4498 0.40591-2.1673 0.22704-2.6657-0.66456-0.49637-0.88783-0.69356-0.67403-0.68084 0.73819 0.0059 0.65847 0.1485 0.99627 0.65598 1.5543 0.95352 1.0485 1.4412 1.4131 2.3002 1.7194 0.99796 0.35592 1.196 0.35402 2.468-0.0237zm-13.78-1.843c-0.077174-0.0772 0.24662-0.32696 0.71955-0.55507 0.55142-0.26597 1.2699-0.92368 2.0028-1.8335 0.62862-0.78032 1.9688-2.1307 2.9781-3.0009 1.0093-0.87018 1.7804-1.6708 1.7134-1.7791-0.07444-0.12046-0.73133-0.14304-1.6906-0.0581-1.7807 0.15764-2.2542-0.0008-2.7251-0.91145-0.1898-0.36705-0.52069-0.64011-0.85991-0.70964-2.0556-0.42135-2.9484-0.98448-4.1182-2.5975-0.41246-0.56873-0.57089-1.024-0.57089-1.6405 0-0.52575-0.12051-0.9533-0.31394-1.1138-0.1728-0.1426-0.6723-0.8629-1.1102-1.6-0.61176-1.0297-0.7962-1.5514-0.7962-2.252 0-1.077 0.59821-1.7896 1.5024-1.7896 0.55434 0 2.9366 0.77871 3.8118 1.246 0.24107 0.12872 2.0062 1.7373 3.9225 3.5747 4.8344 4.6352 5.0408 4.7038 3.2729 1.0887-0.66356-1.3569-1.207-2.6285-1.2076-2.8258-0.0025-0.793-0.4581-1.9218-1.0459-2.5913-0.6957-0.79236-0.66601-1.0241 0.08723-0.68092 0.52983 0.24141 1.3635 1.52 1.3635 2.0912 0 0.18358 0.16854 0.67077 0.37455 1.0826 0.206 0.41188 0.43086 1.0444 0.49969 1.4055 0.06883 0.36115 0.43862 1.1221 0.82175 1.691l0.69661 1.0344 0.21574-0.80118c0.11865-0.44065 0.39777-0.96592 0.62027-1.1673 0.60019-0.54316 0.49697-1.2905-0.40485-2.9311-0.81704-1.4864-0.90201-1.9441-0.25152-1.3547 0.34871 0.31594 1.345 2.1304 1.5493 2.8217 0.08564 0.28969 0.34154 0.35322 1.4227 0.35322h1.3183l0.0018-0.65598c0.0021-0.7249 1.0557-2.7291 1.5305-2.9113 0.50269-0.1929 0.57935 0.11024 0.14944 0.59091-1.3621 1.5229-1.62 3.0058-0.80288 4.6161l0.47357 0.93332 0.52428-0.65707c0.51663-0.64748 1.1823-2.2537 1.5886-3.8335 0.30636-1.191 0.60766-1.7293 1.2241-2.1871 0.80332-0.5966 0.87239-0.30578 0.16664 0.7016-0.39063 0.55758-0.66444 1.2498-0.74736 1.8892-0.07351 0.56691-0.56024 1.8981-1.1106 3.0374-0.98009 2.0289-1.1688 2.7763-0.76416 3.0263 0.11917 0.0737 1.9923-1.6234 4.1882-3.7945 3.7786-3.736 4.0361-3.9489 5.2733-4.36 1.4023-0.46598 2.83-0.55821 3.4558-0.22327 0.31955 0.17102 0.39041 0.42927 0.39041 1.4229 0 1.2966-0.27398 2.0135-1.2387 3.2414-0.39642 0.50455-0.57787 0.96717-0.57787 1.4734 0 1.0178-0.36963 1.6427-1.7504 2.9596-1.0681 1.0187-1.3 1.1458-2.3225 1.2736-1.0124 0.1265-1.163 0.20733-1.3851 0.7434-0.13702 0.33081-0.43848 0.7341-0.66991 0.8962-0.49938 0.34977-1.9278 0.38086-3.3626 0.0732-1.8016-0.38638-1.668-0.16961 1.5055 2.4418 0.74199 0.61056 1.9837 1.8108 2.7593 2.6671 1.0806 1.193 1.5731 1.5875 2.1069 1.6876 0.66093 0.12399 0.99656 0.66367 0.44438 0.71454-0.94393 0.087-2.0794-0.55786-2.8705-1.6302-0.26237-0.35562-0.74382-0.84346-1.0699-1.0841-0.32606-0.24063-0.84014-0.73146-1.1424-1.0907-0.63213-0.75137-3.2893-2.6771-3.6939-2.6771-0.14945 0-0.61328 0.17425-1.0307 0.38721-1.256 0.64076-2.7641 0.82622-4.0323 0.49589-0.60477-0.15752-1.3505-0.4346-1.6571-0.61573-0.52247-0.30863-0.59528-0.30518-1.1586 0.0549-1.4479 0.9255-2.8727 1.9666-2.8727 2.0991 0 0.21393-3.2027 3.477-3.813 3.8848-0.54044 0.36119-1.2588 0.46326-1.5079 0.21424zm6.5197-9.8656c-0.14493-0.17463-0.82492-0.57206-1.5111-0.88319s-1.3107-0.6678-1.3878-0.79262c-0.07714-0.12481-0.33925-0.22347-0.58248-0.21923-0.37404 0.007-0.27892 0.16004 0.61687 0.99574 0.985 0.91891 1.4075 1.1082 2.6492 1.1866 0.41368 0.0261 0.44299-0.013 0.21535-0.28727zm13.045 0.0186c0.98168-0.29481 3.1084-1.9066 2.5092-1.9016-0.46774 0.004-3.6941 1.6639-3.7866 1.9482-0.10528 0.32371 0.0649 0.3175 1.2774-0.0466zm-9.198-0.5081c1.4334-0.50424 2.7586-0.50427 4.0851-0.00011 1.3036 0.49547 1.3646 0.49663 1.3646 0.0258 0-0.20788-0.4067-0.75285-0.90377-1.211-0.89558-0.82552-0.91783-0.83307-2.4548-0.83307-1.2954 0-1.6947 0.0842-2.4229 0.51093-0.88052 0.51602-1.283 1.0164-1.283 1.5951 0 0.40477 0.25407 0.39098 1.6147-0.0876z"),
	UNIT_SPIDER("m15.466 24.906c0-0.0979 0.08562-0.30173 0.19028-0.45291 0.10465-0.15118 0.29514-0.69591 0.42331-1.2105 0.27436-1.1016 0.22055-3.055-0.12971-4.7083-0.12179-0.57485-0.27063-1.3123-0.33076-1.6388-0.06013-0.32648-0.13486-0.61741-0.16606-0.64651s-0.34733-0.27338-0.70251-0.54284l-0.64578-0.48991-0.51703 1.6129c-0.55275 1.7243-0.94376 2.4686-1.5455 2.942-1.1192 0.88038-2.7256-0.48183-3.0542-2.5899-0.15638-1.0034-0.38874-2.1308-0.43913-2.1308-0.02781 0-0.36092 0.17245-0.74025 0.38323-0.60284 0.33497-0.70144 0.45341-0.78301 0.94065-0.05132 0.30659-0.17553 0.71817-0.276 0.91463-0.10047 0.19645-0.3439 0.9775-0.54095 1.7357-0.43041 1.656-0.50245 4.0511-0.14741 4.9008 0.24096 0.57669 0.2026 0.68315-0.17356 0.48184-0.33955-0.18172-0.73718-2.1582-0.73294-3.6432 0.0041-1.4412 0.5933-3.7456 1.314-5.1392 0.27318-0.52827 1.052-1.1948 1.8952-1.6222 0.75659-0.38339 0.94327-0.72155 0.30841-0.55866-0.21078 0.0541-1.0901 0.16361-1.954 0.2434-1.328 0.12265-1.7156 0.10991-2.5084-0.0824-0.51572-0.12514-1.0557-0.22735-1.1999-0.22715-0.14424 0.00014-0.47386-0.13041-0.73249-0.29025-0.80936-0.50021-0.24932-0.73144 0.85074-0.35127 1.0212 0.35294 2.8396 0.50263 3.7588 0.30944 0.83147-0.17474 1.2275-0.50181 0.61238-0.50579-0.51568-0.003-2.1516-1.3003-2.6792-2.1241-0.5713-0.8919-2.3137-2.486-3.6589-3.3475-1.6215-1.0385-1.5504-1.1792 0.2402-0.476 1.6933 0.66502 2.6296 1.3098 3.2423 2.233 0.28442 0.4285 0.92118 1.1892 1.415 1.6904l0.8979 0.91126h0.95634c0.52599 0 0.99595-0.0396 1.0444-0.0879 0.0484-0.0484-0.25089-0.46251-0.6651-0.92022-0.5862-0.6478-0.7874-0.9912-0.9078-1.5494-0.3044-1.4109-0.4257-2.8254-0.3364-3.9225 0.14248-1.7497 1.1087-4.5078 1.6523-4.7163 0.30112-0.11555 0.2766 0.26398-0.05154 0.79793-0.4945 0.80464-0.70846 2.0281-0.70846 4.051 0 1.0472 0.07108 2.3551 0.15796 2.9064 0.14909 0.94607 0.20164 1.0473 0.93629 1.8036 0.73209 0.7537 1.1354 0.98711 1.1354 0.65705 0-0.0793-0.09792-0.29371-0.2176-0.47637-0.1362-0.20788-0.20137-0.55791-0.1742-0.93575 0.03685-0.51242 0.09294-0.61066 0.37116-0.65003 0.30775-0.0436 0.32225-0.0138 0.23766 0.48774-0.12726 0.75443 0.14006 1.1072 0.65962 0.87047 0.29006-0.13217 0.45983-0.13455 0.73251-0.0103 0.53651 0.24445 0.57998 0.21641 0.82958-0.53506 0.12729-0.38322 0.28239-0.69677 0.34468-0.69677 0.16196 0 0.28242 0.37167 0.28242 0.87142v0.43056l0.43886-0.66256 0.43886-0.66255-0.08789-1.6259c-0.159-2.9372-0.935-5.526-1.899-6.3376-0.421-0.35383-0.419-0.5139 0.005-0.5139 0.35479 0 0.90259 0.71813 1.5864 2.0796 0.84091 1.6744 1.0506 2.4759 1.0506 4.0168 0 0.71926 0.05964 1.4192 0.13253 1.5554 0.28478 0.53212-0.56407 2.5431-1.3883 3.2891-0.60363 0.54628-0.24991 0.62451 0.94573 0.20914 0.80656-0.28019 1.4249-0.80735 1.4249-1.2148 0-0.12219 0.15336-0.54199 0.3408-0.93287 0.18744-0.39089 0.46853-1.1558 0.62465-1.6998 0.32471-1.1314 0.92163-1.9642 2.2132-3.0875 1.2825-1.1155 1.3519-0.9679 0.25381 0.54037-0.41154 0.56529-0.87292 1.2786-1.0253 1.5852-0.15237 0.30659-0.44109 0.84272-0.64159 1.1914s-0.45227 1.0524-0.55948 1.5639c-0.21761 1.0381-1.0385 2.4526-1.6198 2.7913-0.19399 0.11301-0.75037 0.25066-1.2364 0.30589-0.48603 0.0552-0.83093 0.14633-0.76646 0.20248 0.31999 0.2786 3.2903 1.0618 3.5106 0.92567 0.07245-0.0448 0.62155-0.14954 1.2202-0.23281 0.59867-0.0832 1.2604-0.2403 1.4706-0.34896 0.41947-0.21693 1.0927-0.2661 1.0927-0.0798 0 0.45783-1.4058 0.96613-3.2052 1.159-1.5842 0.16977-1.6522 0.17107-2.7174 0.0519l-0.83614-0.0936 0.55742 0.45706c1.4966 1.2271 1.6088 1.42 2.2227 3.8216 0.43612 1.7061 0.1372 4.7591-0.62469 6.3799-0.28291 0.60186-0.69216 0.87998-0.69216 0.47038zm-3.1682-8.03c0.8054-0.34523 1.2172-0.87496 1.2172-1.5657 0-0.6304-0.05904-0.64373-1.151-0.25992-1.0031 0.35256-1.5048 0.35136-2.2038-0.005-0.30616-0.15619-0.61721-0.24655-0.69123-0.20081-0.07401 0.0458-0.13458 0.3574-0.13458 0.69256 0 0.65866 0.27184 0.95441 1.2796 1.3921 0.62268 0.27045 0.95368 0.26004 1.6839-0.0529z");

	private final String rawPath;

	/**
	 * Svg constructor.
	 * @param p the raw path
	 */
	Svg(String p) {
		this.rawPath = p;
	}

	/**
	 * @return the SVGPath from the raw path
	 */
	public SVGPath path() {
		SVGPath path = new SVGPath();
		path.setContent(this.rawPath);
		return path;
	}

	/**
	 * @return the path as a string
	 */
	public String rawPath() {
		return this.rawPath;
	}

	@Override
	public String toString() {
		return "Svg[path="+this.rawPath+"]";
	}
}