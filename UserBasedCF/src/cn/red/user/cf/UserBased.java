package cn.red.user.cf;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.ItemBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.common.distance.CosineDistanceMeasure;

public class UserBased {

	private final static int RECOMMENDER_NUM = 1;

	public static void main(String[] args) throws IOException, TasteException {

		String file = "resource/data/testCF.csv";
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
