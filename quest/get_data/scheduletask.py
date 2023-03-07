import schedule
from apscheduler.schedulers.background import BackgroundScheduler
import api


if __name__ == '__main__':


    scheduler = BackgroundScheduler()
    scheduler.add_job(api.daily_today, "cron", hour =18 ,minute =30)

    scheduler.start()

    # schedule.every().day.at("18:30").do(api.daily_today)
    # while True:
    #     schedule.run_pending()