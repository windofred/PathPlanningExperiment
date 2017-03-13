package cn.red.collaborative.filtering;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

//协同过滤的实现类
public class ItemsBasedImpl implements ItemsBased {

	private final static int RECOMMENDER_NUM = 1;
	
	@Override
	public void findFood() throws Exception {
		String file = "resource/data/food.csv";
		// 创建数据模型
		DataModel dataModel = new FileDataModel(new File(file));
		// 物品相似度算法
		ItemSimilarity itemSimilarity = new EuclideanDistanceSimilarity(dataModel);
		// 推荐算法
		ItemBasedRecommender r = new GenericItemBasedRecommender(dataModel,itemSimilarity);

		LongPrimitiveIterator userIDs = dataModel.getUserIDs();
		while (userIDs.hasNext()) {
			Long uid = userIDs.nextLong();
			List<RecommendedItem> list = r.recommend(uid, RECOMMENDER_NUM);
			System.out.printf("uid:%s", uid);
			for (RecommendedItem ritem : list) {
				System.out.printf("(%s,%f)", ritem.getItemID(),ritem.getValue());
			}
			System.out.println();
		}

	}

	@Override
	public void findCostume() throws Exception {
		String file = "resource/data/costume.csv";
		// 创建数据模型
		DataModel dataModel = new FileDataModel(new File(file));
		// 物品相似度算法
		ItemSimilarity itemSimilarity = new EuclideanDistanceSimilarity(dataModel);
		// 推荐算法
		ItemBasedRecommender r = new GenericItemBasedRecommender(dataModel,itemSimilarity);

		LongPrimitiveIterator userIDs = dataModel.getUserIDs();
		while (userIDs.hasNext()) {
			Long uid = userIDs.nextLong();
			List<RecommendedItem> list = r.recommend(uid, RECOMMENDER_NUM);
			System.out.printf("uid:%s", uid);
			for (RecommendedItem ritem : list) {
				System.out.printf("(%s,%f)", ritem.getItemID(),
						ritem.getValue());
			}
			System.out.println();
		}
	}

	@Override
	public void findCosmetic() throws Exception {
		String file = "resource/data/cinema.csv";
		// 创建数据模型
		DataModel dataModel = new FileDataModel(new File(file));
		// 物品相似度算法
		ItemSimilarity itemSimilarity = new EuclideanDistanceSimilarity(dataModel);
		// 推荐算法
		ItemBasedRecommender r = new GenericItemBasedRecommender(dataModel,itemSimilarity);

		LongPrimitiveIterator userIDs = dataModel.getUserIDs();
		while (userIDs.hasNext()) {
			Long uid = userIDs.nextLong();
			List<RecommendedItem> list = r.recommend(uid, RECOMMENDER_NUM);
			System.out.printf("uid:%s", uid);
			for (RecommendedItem ritem : list) {
				System.out.printf("(%s,%f)", ritem.getItemID(),
						ritem.getValue());
			}
			System.out.println();
		}
	}

}
