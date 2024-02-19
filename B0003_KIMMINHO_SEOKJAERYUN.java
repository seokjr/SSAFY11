import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class B0003_KIMMINHO_SEOKJAERYUN {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "대전3반_THE_teulMINO";

	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int) balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				// - order: 1인 경우 선공, 2인 경우 후공을 의미
				// - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				// 예) balls[0][0]: 흰 공의 X좌표
				// balls[0][1]: 흰 공의 Y좌표
				// balls[1][0]: 1번 공의 X좌표
				// balls[4][0]: 4번 공의 X좌표
				// balls[5][0]: 마지막 번호(8번) 공의 X좌표

				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

				// 내가 쳐야할 공들인지 확인하고 넣어놓기 위함
				boolean[] isTarget = new boolean[6];
				// 선공일 경우
				// else if를 안쓰는 이유는 for문을 도는 것이 아니기에 그냥 한번에 넣으려고
				if (order == 1) {
					if (balls[1][0] != -1) {
						isTarget[1] = true;
					}
					if (balls[3][0] != -1) {
						isTarget[3] = true;
					}
					if (balls[5][0] != -1) {
						isTarget[5] = true;
					}
				}
				// 후공일 경우
				else {
					if (balls[2][0] != -1) {
						isTarget[2] = true;
					}
					if (balls[4][0] != -1) {
						isTarget[4] = true;
					}
					if (balls[5][0] != -1) {
						isTarget[5] = true;
					}
				}

				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				float whiteBall_x = balls[0][0];
				float whiteBall_y = balls[0][1];

				// targetBall_x, targetBall_y: 목적구의 X, Y좌표를 나타내기 위해 사용한 변수
				float targetBall_x = balls[1][0];
				float targetBall_y = balls[1][1];

				// 공을 넣어야 할지 안 넣어야 할지 판단하고 이미 공을 넣으면 -1로 바뀐다.

				// 마지막 공은 무조건 5번 공이 될 수 있도록 한다.
				for (int i = 1; i <= 5; i++) {
					if (isTarget[i]) {
						targetBall_x = balls[i][0];
						targetBall_y = balls[i][1];
						// 먼저 targetBall을 찾게 되면 멈춘다.
						break;
					}
				}

				// targetBall과 가장 가까운 홀을 찾는다.
				float hole_x = 0;
				float hole_y = 0;
				float target_and_hole_width = 0;
				float target_and_hole_height = 0;
				double target_and_hole_radian = 0.0d;
				float target_and_hole_angle = 0.0f;
				int pluselement = 0;
				float F_TABLE_WIDTH = TABLE_WIDTH;
				float F_TABLE_HEIGHT = TABLE_HEIGHT;
				// 좌하단
				if (0 < targetBall_x && targetBall_x < F_TABLE_WIDTH / 4 && 0 <= targetBall_y
						&& targetBall_y < F_TABLE_HEIGHT / 2) {
					System.out.println("좌하단입니다.=--------------");
					hole_x = 0;
					hole_y = 0;
					target_and_hole_width = Math.abs(targetBall_x - hole_x);
					target_and_hole_height = Math.abs(targetBall_y - hole_y);
					// 3사분면 식
					target_and_hole_radian = Math.atan(target_and_hole_width / target_and_hole_height);
					target_and_hole_angle = (float) (((180.0 / Math.PI) * target_and_hole_radian) + 180);
				}
				// 중하단
				else if (F_TABLE_WIDTH / 4 <= targetBall_x && targetBall_x < (F_TABLE_WIDTH / 4) * 3
						&& 0 <= targetBall_y && targetBall_y < F_TABLE_HEIGHT / 2) {
					System.out.println("중하단입니다.=--------------");
					hole_x = F_TABLE_WIDTH / 2;
					hole_y = 0;
					target_and_hole_width = Math.abs(targetBall_x - hole_x);
					target_and_hole_height = Math.abs(targetBall_y - hole_y);
					// 1~2사분면 식
					// 목적구 기준 구멍의 위치를 분면처리한 것
					// 3분면
					if (F_TABLE_WIDTH / 4 < targetBall_x && targetBall_x < F_TABLE_WIDTH / 2)
						pluselement = 180;
					// 4분면
					else
						pluselement = 90;
					target_and_hole_radian = Math.atan(target_and_hole_width / target_and_hole_height);
					target_and_hole_angle = (float) (((180.0 / Math.PI) * target_and_hole_radian) + pluselement);
				}
				// 우하단
				else if ((F_TABLE_WIDTH / 4) * 3 <= targetBall_x && targetBall_x < F_TABLE_WIDTH && 0 <= targetBall_y
						&& targetBall_y < F_TABLE_HEIGHT / 2) {
					System.out.println("우하단입니다.=--------------");
					hole_x = F_TABLE_WIDTH;
					hole_y = 0;
					target_and_hole_width = Math.abs(hole_x - targetBall_x);
					target_and_hole_height = Math.abs(targetBall_y - hole_y);
					// 4사분면 식
					target_and_hole_radian = Math.atan(target_and_hole_height / target_and_hole_width);
					target_and_hole_angle = (float) (((180.0 / Math.PI) * target_and_hole_radian) + 90);
				}
				// 좌상단
				else if (0 < targetBall_x && targetBall_x < F_TABLE_WIDTH / 4 && F_TABLE_HEIGHT / 2 <= targetBall_y
						&& targetBall_y < F_TABLE_HEIGHT) {
					System.out.println("좌상단입니다.=--------------");
					hole_x = 0;
					hole_y = F_TABLE_HEIGHT;
					target_and_hole_width = Math.abs(targetBall_x - hole_x);
					target_and_hole_height = Math.abs(hole_y - targetBall_y);
					// 2사분면 식
					target_and_hole_radian = Math.atan(target_and_hole_height / target_and_hole_width);
					target_and_hole_angle = (float) (((180.0 / Math.PI) * target_and_hole_radian) + 270);
				}
				// 중상단
				else if (F_TABLE_WIDTH / 4 <= targetBall_x && targetBall_x < (F_TABLE_WIDTH / 4) * 3
						&& F_TABLE_HEIGHT / 2 <= targetBall_y && targetBall_y < F_TABLE_HEIGHT) {
					System.out.println("중상단입니다.=--------------");
					hole_x = F_TABLE_WIDTH / 2;
					hole_y = F_TABLE_HEIGHT;
					target_and_hole_width = Math.abs(targetBall_x - hole_x);
					target_and_hole_height = Math.abs(hole_y - targetBall_y);
					// 1~2사분면 식인데
					// 2분면
					if (F_TABLE_WIDTH / 2 <= targetBall_x && targetBall_x < (F_TABLE_WIDTH / 4) * 3) {
						pluselement = 270;
					}
					// 1분면
					else {
						pluselement = 0;
					}
					target_and_hole_radian = Math.atan(target_and_hole_height / target_and_hole_width);
					target_and_hole_angle = (float) (((180.0 / Math.PI) * target_and_hole_radian) + pluselement);
				}
				// 우상단
				else if ((F_TABLE_WIDTH / 4) * 3 < targetBall_x && targetBall_x < F_TABLE_WIDTH
						&& F_TABLE_HEIGHT / 2 <= targetBall_y && targetBall_y < F_TABLE_HEIGHT) {
					System.out.println("우상단입니다.=--------------");
					hole_x = F_TABLE_WIDTH;
					hole_y = F_TABLE_HEIGHT;
					target_and_hole_width = Math.abs(hole_x - targetBall_x);
					target_and_hole_height = Math.abs(hole_y - targetBall_y);
					// 1사분면 식
					target_and_hole_radian = Math.atan(target_and_hole_width / target_and_hole_height);
					target_and_hole_angle = (float) (((180.0 / Math.PI) * target_and_hole_radian));
				}
				// 그 홀과 targetBall이 이루는 각도를 찾는다.
				// 찾았는데 여기서 더 하기가 너무 힘들다.. 뭔가를 계산해야하는데 아이디어가 떠오르지 않는다.
				// 그리고 현재 칠 각도와 홀과 목적구가 이루는 각도를 계산해서 하면 될 듯하다.
				// 공과 홀의 x와 y좌표 거리가 둘 다 5미만으로 떨어져있을 땐 거의 붙어있는 거니까 직선으로 빵 때려도 되지만 다른 경우에는 살짝 꺾어서
				// 쳐주면 될 듯하다.
				// 사실 각 홀의 뭔가를 구할게 아니라.

				// width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리
				float width = Math.abs(targetBall_x - whiteBall_x);
				float height = Math.abs(targetBall_y - whiteBall_y);

				// radian: width와 height를 두 변으로 하는 직각삼각형의 각도를 구한 결과
				// - 1radian = 180 / PI (도)
				// - 1도 = PI / 180 (radian)
				// angle : 아크탄젠트로 얻은 각도 radian을 degree로 환산한 결과
				double radian = height > 0 ? Math.atan(width / height) : 0;
				angle = (float) ((180.0 / Math.PI) * radian);

				// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
				if (whiteBall_x == targetBall_x) {
					if (whiteBall_y < targetBall_y) {
						angle = 0;
					} else {
						angle = 180;
					}
				} else if (whiteBall_y == targetBall_y) {
					if (whiteBall_x < targetBall_x) {
						angle = 90;
					} else {
						angle = 270;
					}
				}
				// 그냥 일단 test 통과는 각도를 1을 조절해서 쳐주면 된다.
				// 뭔가를 줄일 변수
				int something = 1;

				// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산 3사분면은 + 해줘야 살짝 각도를 위로 향하게 칠 수 있다.
				if (whiteBall_x > targetBall_x && whiteBall_y > targetBall_y) {
					System.out.println("3사분면 " + "폭 : " + width + " 높이 : " + height);
					radian = Math.atan(width / height);
					angle = (float) (((180.0 / Math.PI) * radian) + 180 + something);
				}

				// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산 4사분면은 - 해줘야 살짝 각도를 위로 향하게 칠 수 있다.
				else if (whiteBall_x < targetBall_x && whiteBall_y > targetBall_y) {
					System.out.println("4사분면 " + "폭 : " + width + " 높이 : " + height);
					radian = Math.atan(height / width);
					angle = (float) (((180.0 / Math.PI) * radian) + 90 - something);
				}
				// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도를 재계산 2사분면은 - 해줘야 살짝 각도를 위로 향하게 칠 수 있다.
				else if (whiteBall_x > targetBall_x && whiteBall_y < targetBall_y) {
					System.out.println("2사분면 " + "폭 : " + width + " 높이 : " + height);
					radian = Math.atan(height / width);
					angle = (float) (((180.0 / Math.PI) * radian) + 270 - something);
				}
				// 목적구가 흰 공을 중심으로 1사분면에 위치했을 때 각도를 재계산 1사분면은 + 해줘야 살짝 각도를 위로 향하게 칠 수 있다.
				// 여기서 else if로 하는 이유는 혹시나라도 같을 때의 조건과 동일할 수도 있기 때문에
				else if (whiteBall_x < targetBall_x && whiteBall_y < targetBall_y) {
					System.out.println("1사분면 " + "폭 : " + width + " 높이 : " + height);
					radian = Math.atan(width / height);
					angle = (float) (((180.0 / Math.PI) * radian + something));
				}
//				angle = angle - ((target_and_hole_angle - angle) / 2);
//				if (target_and_hole_angle > 270 || 90 > target_and_hole_angle) {
//					angle = angle + (((target_and_hole_angle + angle) % 360) / 20);
//				}
//				else {
//					angle = angle - (((target_and_hole_angle + angle) % 360) / 20);
//				}
//				System.out.println("변경 후 앵글 : " + angle);
				// distance: 두 점(좌표) 사이의 거리를 계산
				double distance = Math.sqrt((width * width) + (height * height));

				// power: 거리 distance에 따른 힘의 세기를 계산
				// 힘의 세기를 좀 줄일 필요가 있어보인다.
				// 힘의 세기도 만약 targetBall과 hole과의 거리가 가까우면 살살 치게 한다.
				power = (float) distance;
//				power = (float) 60;

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				// - angle: 흰 공을 때려서 보낼 방향(각도)
				// - power: 흰 공을 때릴 힘의 세기
				//
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
