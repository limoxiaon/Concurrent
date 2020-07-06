package SuiDynasty;

/**
 * 隋唐演义大戏舞台
 */
public class Stage extends Thread {

	public void run(){

		System.out.println("欢迎观看隋唐演义");
		//让观众们静静等待，大戏即将开始
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("大幕徐徐拉开");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("话说隋朝末年，隋军与农民起义军杀得昏天黑地...");
		ArmyRunnable armyOfSuiRun=new ArmyRunnable();
		ArmyRunnable armyOfQiYiRun=new ArmyRunnable();

		//使用Runnable创建线程
		Thread armyOfSui =new Thread(armyOfSuiRun,"隋朝军队");
		Thread armyOfQiYi=new Thread(armyOfQiYiRun,"起义军");

		//发起攻击
		armyOfQiYi.start();
		armyOfSui.start();

		//舞台线程开始休眠，让观众专心看剧
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("正当双方激战正酣，半路杀出了个程咬金");

		Thread  mrCheng = new KeyPersonThread();
		mrCheng.setName("程咬金");

		System.out.println("程咬金的理想就是结束战争，使百姓安居乐业！");

		//发出信号，战斗结束
		armyOfQiYiRun.keepRunning=false;
		armyOfSuiRun.keepRunning=false;

		//留出时间，让战斗结束
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/*
		 * 历史大戏留给关键人物
		 */
		mrCheng.start();

		//万众瞩目，所有线程等待程先生完成历史使命
		try {
			//所有线程都需要等待当前线程执行完毕
			mrCheng.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("战争结束，人民安居乐业，程先生实现了积极的人生梦想，为人民作出了贡献！");
		System.out.println("谢谢观看隋唐演义，再见！");
	}
	
	public static void main(String[] args) {
		new Stage().start();
	}

}
